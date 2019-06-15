package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String date1 = reader.readLine();

        //Считать строку и преобразовать в дату
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(date1);

        //Дату преобразовать в строку, но в другом формате
        SimpleDateFormat formatForPrint = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String dateForPrint  = formatForPrint.format(date);

        System.out.println(dateForPrint.toUpperCase());
    }
}
