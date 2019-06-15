package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 0829
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean continueWhile = true;

        // List of addresses
        Map<String, String> addresses = new HashMap();
        while (continueWhile) {
            String city = reader.readLine();

            if (city.isEmpty()) {
                continueWhile = false;
                break;
            }

            String family = reader.readLine();

            if (family.isEmpty()) {
                continueWhile = false;
                break;
            }

            addresses.put(city, family);
        }

        // Read the house number
        String findedCity = reader.readLine();

        System.out.println(addresses.get(findedCity));
    }
}
