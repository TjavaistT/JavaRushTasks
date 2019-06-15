package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 0815
Перепись населения
*/

public class Solution {
    //Юля, грац за список - Вот уж не думал что так быстро приходится :)
    public static HashMap<String, String> createMap() {
        HashMap<String, String> peoples = new HashMap<>();
        peoples.put("Устименко", "Дарья");
        peoples.put("Цокало", "Юлия");
        peoples.put("Вассерман", "Мария");
        peoples.put("Огуй", "Диана");
        peoples.put("Левина", "Елена");
        peoples.put("Кашлюк", "Анжелика");
        peoples.put("Павленко", "Анастасия");
        peoples.put("Матяк-Яблучкина", "Елена");
        peoples.put("Ненада", "Анастасия");
        peoples.put("Касницкая", "Виктория");

        return peoples;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int sameNames = 0;
        for (Map.Entry<String, String> fio: map.entrySet()) {
            if(fio.getKey().equals(lastName)){
                sameNames++;
            }
        }

        return sameNames;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int sameNames = 0;
        for (Map.Entry<String, String> fio: map.entrySet()) {
            if(fio.getValue().equals(name)){
                sameNames++;
            }
        }

        return sameNames;
    }

    public static void main(String[] args) {
        HashMap<String, String> peoples = createMap();
        String name = "Елена";
        String lastName = "Премудрая";

//        for (Map.Entry<String, String> fio: peoples.entrySet()) {
//            System.out.println(fio.getKey() + " - " + fio.getValue());
//        }

        int sameName = getCountTheSameFirstName(peoples, name);
        int sameLastName = getCountTheSameFirstName(peoples, lastName);

//        System.out.println("sameName:" +sameName);
//        System.out.println("lastName:" + sameLastName);
    }
}