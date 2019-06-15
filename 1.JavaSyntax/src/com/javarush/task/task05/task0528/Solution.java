package com.javarush.task.task05.task0528;

import java.text.*;
import java.util.*;
/*
Вывести на экран сегодняшнюю дату
*/

public class Solution {

    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

        System.out.println(dateFormat.format(currentDate));
    }
}
