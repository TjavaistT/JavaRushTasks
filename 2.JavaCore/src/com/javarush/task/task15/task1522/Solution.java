package com.javarush.task.task15.task1522;

/*
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {

        String key = readKeyFromConsole();

        initPlanet(key);
    }

    private static String readKeyFromConsole(){
        String key = "";
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        try {

            key =  bufferedReader.readLine().trim().toLowerCase();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return key;
    }

    private static void initPlanet(String key){
        switch (key){
            case Planet.SUN:
                Solution.thePlanet = Sun.getInstance();
                break;
            case Planet.MOON:
                Solution.thePlanet = Moon.getInstance();
                break;
            case Planet.EARTH:
                Solution.thePlanet = Earth.getInstance();
                break;
            default:
                Solution.thePlanet = null;
                break;
        }
    }
}
