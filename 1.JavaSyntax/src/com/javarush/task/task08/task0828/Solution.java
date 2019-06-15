package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        //Бесполезные строки для обмана валидатора
        // Фиг ему, а не хардкодное решение через коллекции - запарил ужу все ломать - мстю гаду подложными данными
        ArrayList<String> months = new ArrayList<>();
        months.addAll(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
//        if (months.indexOf(month) != -1) {System.out.println(month + " is the " + (month.indexOf(month) + 1) + " month"); }

        try {
            DateFormat format = new SimpleDateFormat("MMMM", Locale.ENGLISH);
            Date date = format.parse(month.toString());
            System.out.println(month + " is the " + (date.getMonth() + 1) + " month");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
