package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы CanRun, CanSwim
*/

public class Solution {
    public static void main(String[] args) {

    }

    private interface CanSwim{
        public void swim();
    }

    public interface CanRun{
        public void run();
    }

    abstract public class Human implements CanRun, CanSwim{

    }
}
