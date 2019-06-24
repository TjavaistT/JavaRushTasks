package com.javarush.task.task15.task1527;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String resultString = "";

    try {
        String[] params = new URL(scanner.nextLine().trim()).getQuery().split("&");

        //если для каждой задачи снова и снова парсить строку - то это не правильно - нужно данные в чем-то хранить - лучшее что нашел - Мапа(асс.Массив)
        //Данные будут переиспользоватся - нам нужен ассоциативный массив(мапа) для хранения
        //LinkedHashMap - выводит значения в том порядке что и записал
        LinkedHashMap<String[], String> elements = new LinkedHashMap();

        for (String param : params) {
            String[] paramPair = param.split("=");
            //Нам нужны дубли клучей, потому что названия параметров могут повторятся!
            // - поэтому в ключах используем массивы, а не строки
            String[] key = {""};
            String value = "";

            // не у каждого ключа есть соответствующее значение
            // - это нужно учесть при распаршивании строк и подставить пустоту в необходимых местах
            try {
                key[0] = paramPair[0];
                value = paramPair[1];
            } catch (Exception e){

            } finally {
                elements.put(key, value);
                resultString += key[0] + " ";
            }
        }

        System.out.print(resultString.trim());
        System.out.println();

        Iterator it = elements.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            String k = ((String[]) pair.getKey())[0];
            String v = (String) pair.getValue();

            if (k.equals("obj") && isDouble(v)) {
                double d = Double.parseDouble(v);
                alert(d);
            } else if(k.equals("obj")) {
                alert(v);
            }
        }



    } catch (MalformedURLException e) {
        System.out.println("Нужно ввести URL");
        e.printStackTrace();
    } catch (Exception e){
        e.printStackTrace();
    }

    }

    public static boolean isDouble(String s){
        try{
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
