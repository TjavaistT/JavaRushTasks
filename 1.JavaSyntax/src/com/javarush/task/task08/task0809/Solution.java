package com.javarush.task.task08.task0809;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
Время для 10 тысяч вставок
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getInsertTimeInMs(new ArrayList()));
        System.out.println(getInsertTimeInMs(new LinkedList()));
    }

    public static long getInsertTimeInMs(List list) {
        long start = System.currentTimeMillis();

        insert10000(list);

        long end = System.currentTimeMillis();

        return end - start;
    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000000; i++) {
            list.add(0, new Object());
        }
    }
}
