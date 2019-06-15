package com.javarush.task.task01.task0133;
import java.util.*;
import java.lang.*;
import java.text.*;
/*
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {

        Calendar calendar1 = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();

        calendar1.set(Calendar.HOUR_OF_DAY, 15);
        calendar1.set(Calendar.MINUTE, 30);

        calendar2.set(Calendar.HOUR_OF_DAY, 15);
        calendar2.set(Calendar.MINUTE, 00);

        long difference = calendar1.getTimeInMillis() - calendar2.getTimeInMillis();

//        String date1 = "15:30";
//        String date2 = "15:00";
//
//        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
//
//        try {
//            long difference = format.parse(date1).getTime() - format.parse(date2).getTime();
        long seconds =  difference / 1000; // миллисекунды

            System.out.println(seconds);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}