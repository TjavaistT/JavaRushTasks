package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<String>(5);

        for (int i = 0; i < 5; i++) {
            arrayList.add("string - " + i);
        }

        System.out.println(arrayList.size());

        for (String string : arrayList) {
            System.out.println(string);
        }
    }
}
