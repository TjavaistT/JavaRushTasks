package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Знакомство с properties
*/
public class Solution {
    public static Properties objProps = new Properties();
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        try (
                Scanner scanConsole = new Scanner(System.in);
                FileInputStream inputFile = new FileInputStream(scanConsole.nextLine());
        ){
            load(inputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        objProps.putAll(properties);
        objProps.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        objProps.load(inputStream);
        objProps.forEach((K, V) -> properties.put((String) K, (String)V));
    }

    public static void main(String[] args) {

        new Solution().fillInPropertiesMap();

        // для проверки save
//        Scanner scanConsole = new Scanner(System.in);
//        try {
//
//            properties.put("prop3", "value3");
//            properties.put("prop4", "value4");
//
//            FileOutputStream outputFile = new FileOutputStream(scanConsole.nextLine());
//            new  Solution().save(outputFile);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
