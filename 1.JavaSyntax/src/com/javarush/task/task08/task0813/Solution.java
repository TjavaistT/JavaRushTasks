package com.javarush.task.task08.task0813;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        HashSet<String> set = new HashSet<>();
        int count = 20;
        int stringLength = 10;
        Random random = new Random();
        String[] strings = new String[count];

        for (int i = 0; i < strings.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < stringLength; j++) {
                char code = (char) (random.nextInt(94) + 33);
                builder.append(Character.toString(code));
            }
            set.add("Л" + builder.toString());
        }

        return set;
    }

    public static void main(String[] args) {
        HashSet<String> set = (HashSet<String>) createSet();
    }

}
