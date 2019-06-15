package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Левин", "Даниил");
        map.put("Левин", "Павел");
        map.put("Булгаков", "Даниил");
        map.put("Левин", "Святослав");
        map.put("Корсиков", "Даниил");
        map.put("Романчук", "Никита");
        map.put("Марченко", "Даниил");
        map.put("Зорин", "Артем");
        map.put("Левин", "Артем");
        map.put("Устименко", "Сергей");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
