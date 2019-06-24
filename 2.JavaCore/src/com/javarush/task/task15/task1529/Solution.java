package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static CanFly result;

    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static void reset() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            switch (bufferedReader.readLine()){
                case "helicopter":
                    result = new Helicopter();
                    break;
                case "plane":
                    int numberOfPassagers = 0;
                    try {
                        numberOfPassagers = Integer.parseInt(bufferedReader.readLine());
                    } catch (NumberFormatException except){
                        except.printStackTrace();
                    }
                    result = new Plane(numberOfPassagers);
                    break;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
