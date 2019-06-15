package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> salaries = new HashMap<>();
        // даю тебе хороший способ выразить все обиды или благодрности подржкам
        // в твоих руках их зарплата! :)
        salaries.put("Устименко", 100);
        salaries.put("Цокало", 1000);
        salaries.put("Вассерман", 500);
        salaries.put("Огуй", 600);
        salaries.put("Левина", 300);
        salaries.put("Кашлюк", 700);
        salaries.put("Павленко", 400);
        salaries.put("Матяк-Яблучкина", 300);
        salaries.put("Ненада", 200);
        salaries.put("Касницкая", 300);

        return salaries;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator mapIterator = map.entrySet().iterator();

        while (mapIterator.hasNext()){
            //не забывай про контроль возвращаемого типа (Map.Entry<String, Integer>)  и будет тебе счастье
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) mapIterator.next();

            if (pair.getValue() < 500){
                mapIterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> salaries = createMap();
        removeItemFromMap(salaries);
    }
}