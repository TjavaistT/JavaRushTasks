package com.javarush.task.task18.task1805;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = new Scanner(System.in).nextLine();

        //по условий необходимо использовать FileInputStream - поэтому здесь код, как в старых версиях Java
        ArrayList<Integer> bytes = new ArrayList<>();
        try (InputStream frider = new FileInputStream(new File(filename))) {


            while (frider.available() > 0) {
                bytes.add(frider.read());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        //отсортировать по умолчанию по возрастанию
         bytes.stream().sorted()
                 //убрать дублирующиеся значения, с отсортированном массиве и в одном потоке, это делается быстрее чем в не отсортированном
                 .distinct()
                 //вывести все значения через пробел
                 .forEach(s -> System.out.print(s + " "));
    }
}
