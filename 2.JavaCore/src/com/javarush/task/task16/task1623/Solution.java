package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
            System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{

        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            this.start();
        }

        @Override
        public void run() {
            if (createdThreadCount < Solution.count) {
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
