package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> fruits = new HashSet<String>(10);
        
        fruits.add("арбуз");
        fruits.add("банан");
        fruits.add("вишня");
        fruits.add("груша");
        fruits.add("дыня");
        fruits.add("ежевика");
        fruits.add("женьшень");
        fruits.add("земляника");
        fruits.add("ирис");
        fruits.add("картофель");

        fruits.forEach(System.out::println);
    }
}
