package com.javarush.task.task07.task0715;

import java.io.*;
import java.util.*;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] arWords = {"мама", "мыла", "раму"};
        ArrayList<String> words = new ArrayList<String>();

        Collections.addAll(words, arWords);

        for (int i = words.size()-1; i >= 0; i--) {
            words.add(i + 1, "именно");
        }

        words.forEach(System.out::println);
    }
}
