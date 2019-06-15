package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Random;

/*  Задача 1015 - код необходимо логически разбивать на методы - тогда в разы повышается читабельность
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //ничего личного не имею против пустых массивов, просто хотел бы их избежать, поэтому +1
        ArrayList<String>[] strings = new ArrayList[(new Random()).nextInt(5) + 1];

        for (int i = 0; i < strings.length; i++) {
           strings[i] = createStringArray();
        }

        return strings;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static String createLine(int stringLength){
        Random random = new Random();
        String newLine = "";
        StringBuilder builder = new StringBuilder();

        for (int k = 0; k < stringLength; k++) {
            char code = (char) (random.nextInt(94) + 33);
            builder.append(Character.toString(code));
        }
        return builder.toString();
    }

    public static ArrayList<String> createStringArray(){
        Random random = new Random();
        int stringLength = random.nextInt(5)+1;
        int innerArrayLength = random.nextInt(5)+1;
        ArrayList<String> innerArray = new ArrayList<String>(innerArrayLength);

        for (int j = 0; j < innerArrayLength; j++) {
            String newLine = createLine(stringLength);
            innerArray.add(newLine);
        }

        return innerArray;
    }
}