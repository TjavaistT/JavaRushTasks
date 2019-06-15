package com.javarush.task.task12.task1208;

/* 
Свобода печати
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static void print(int num){
        System.out.println(num);
    }

    public static void print(Integer number){
        System.out.println(number);
    }

    public static void print(String s){
        System.out.println(s);
    }

    public static void print(String[] strings){
        for (String str:strings) {
            System.out.println(str);
        }
    }

    public static void print(Integer[] integers){
        for (Integer integ:integers) {
            System.out.println(integ);
        }
    }
}
