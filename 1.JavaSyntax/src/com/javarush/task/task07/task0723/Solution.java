package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
*/

public class Solution {
    public static void main(String[] args) {
        try {
            for (int i = 30; i >= 0; i--) {
                System.out.println(i);

                Thread.sleep(100);
            }

            System.out.println("Бум!");

        } catch (Exception except){
            System.out.println(except);
        }
    }
}
