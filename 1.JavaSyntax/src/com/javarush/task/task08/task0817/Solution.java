package com.javarush.task.task08.task0817;

import java.io.*;
import java.util.*;
import java.lang.*;
/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Погорелов", "Даниил");
        map.put("Левин", "Павел");
        map.put("Булгаков", "Николай");
        map.put("Карпов", "Святослав");
        map.put("Корсиков", "Олег");
        map.put("Романчук", "Никита");
        map.put("Марченко", "Алексей");
        map.put("Зорин", "Артем");
        map.put("Лутченко", "Сергей"); //прости Дима - быть тебе Сергеем
        map.put("Устименко", "Сергей");

        return map;
    }

    //пользуясь теми же костылями создаем копию массива и будем перебирать эту копию
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for(Map.Entry<String, String> fio: copy.entrySet()){
            if(getCountTheSameFirstName(map, fio.getValue()) > 1){
                removeItemFromMapByValue(map, fio.getValue());
            }
        }

        //по условию задания результат на экран не выводится - на слово верят)
        //System.out.println(map);
    }

    //костыльный метод который предлагает джавараш
    // копируем словарь и перебираем копию, а удаляем из оригинала
    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int sameNames = 0;
        for (Map.Entry<String, String> fio: map.entrySet()) {
            if(fio.getValue().equals(name)){
                sameNames++;
            }
        }

        return sameNames;
    }
}
