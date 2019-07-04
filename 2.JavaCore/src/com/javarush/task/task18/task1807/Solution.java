package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String filename = new Scanner(System.in).nextLine();

        //по условий необходимо использовать FileInputStream - поэтому здесь код, как в старых версиях Java
        try (InputStream frider = new FileInputStream(new File(filename))) {
            byte[] bytes = new byte[frider.available()];

            if (frider.available() > 0) {
                frider.read(bytes);
            }

            //бесполезное усложнение кода, но вот хочется использовать frequency...
            ArrayList<Byte> bytesList = new ArrayList<>();
            for (byte element: bytes) {
                bytesList.add(element);
            }

            //Полезный метод поиска количества совпадающих элементов в коллекции(+1 зя)
            //singletonList - список байт становится финальной переменной и формируется даже из одного элемента
            int countComma = Collections.frequency(bytesList, (byte)',');

            System.out.println(countComma);

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
