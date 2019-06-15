package com.javarush.task.task07.task0716;

import java.util.*;

/* 0716
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //Для того чтобы перебирать и изменять список существует улучшеный итератор ListIterator
        ListIterator iterList = list.listIterator();

        while (iterList.hasNext()) {
            String string = (String) iterList.next();
            if(string.contains("р") && string.contains("л")){

            } else if(string.contains("р")){
                iterList.remove();
            } else if(string.contains("л")){
                iterList.add(string);
            }
        }

        return list;

        //все методы итерации
//        List<String> colors = Arrays.asList("red", "yellow",  "blue", "black", "orange", "white","green");
//
//        // Basic loop
//        for (int i = 0; i < colors.size(); i++) {
//            String color = colors.get(i);
//            printItemList(color);
//        }
//
//
//        // foreach
//        for (String color : colors) {
//            printItemList(color);
//        }
//
//        // Basic loop with iterator
//        for (Iterator<String> it = colors.iterator(); it.hasNext(); ) {
//            String color = it.next();
//            printItemList(color);
//        }
//
//        // Iterator with while loop
//        Iterator<String> it = colors.iterator();
//        while (it.hasNext()) {
//            String color = it.next();
//            printItemList(color);
//        }
//
//        // JDK 8 streaming example lambda expression
//        colors.stream().forEach(color -> printItemList(color));
//
//        // JDK 8 streaming example method reference
//        colors.stream().forEach(ListExample::printItemList);
//
//        // JDK 8 for each with lambda
//        colors.forEach(color -> printItemList(color));
//
//        // JDK 8 for each
//        colors.forEach(ListExample::printItemList);
    }
}