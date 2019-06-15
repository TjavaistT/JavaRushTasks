package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 0827
Работа с датой
*/
// Текст в дату - Дату в Календарь - а в календаре куча полезных констант
// одна из которых "количество дней с начала года"
// возможно не лучшее решение - но ты не видела предыдущих:))
public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date date2 = format.parse(date);

        GregorianCalendar calendar = new GregorianCalendar(date2.getYear(), date2.getMonth(), date2.getDate());

        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        return calendar.get(Calendar.DAY_OF_YEAR) % 2 != 0;
    }
}
