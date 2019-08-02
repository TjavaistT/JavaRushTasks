package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))
        ){
            List<Person> persons = bufferedReader.lines()
                    .map(line -> line.split("\\s+"))
                    .map(arLine -> new Person(
                            createName(Arrays.copyOfRange(arLine, 0,arLine.length-3)),
                            createBirthday(Arrays.copyOfRange(arLine, arLine.length-3, arLine.length)
                        )))
                    .collect(Collectors.toList());

            PEOPLE.addAll(persons);

            // Есть более красивое решение

//            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
//            while (reader.ready()) {
//                String line = reader.readLine();
//                name = line.replaceAll("\\d", "").trim();
//                date = line.replace(name, "").trim();
//                PEOPLE.add(new Person(name, sdf.parse(date))); }

            //но в таком решении потеряется R2D2 :)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String createName(String[] nameParts) {
        StringBuilder name = new StringBuilder();

        for (String partName: nameParts) {
            name.append(partName).append(" ");
        }

        return name.toString().trim();
    }

    private static Date createBirthday(String[] dateParts) {
        return new GregorianCalendar(Integer.valueOf(dateParts[2]), Integer.valueOf(dateParts[1]) -1, Integer.valueOf(dateParts[0])).getTime();
    }
}
