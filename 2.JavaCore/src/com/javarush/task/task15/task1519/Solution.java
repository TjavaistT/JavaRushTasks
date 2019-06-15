package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* Задача 1519 - не так просто оказалось получить различные типы из строки
* очень поучительная задача - попробуй запомнить ее структуру - когда нибудь ты обязательно столкнешся с такой проблемой
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //открыть поток на считывание
        InputStreamReader inputReader = new InputStreamReader(System.in);
        //оптимизируем поток на считывание, чтобы читать целыми линиями
        BufferedReader bufferReader = new BufferedReader(inputReader);
        String line = bufferReader.readLine();

        while (!line.equals("exit")) {

            //многие строки можно одновременно преобразовать ко всем форматам,
            // поэтому важен порядок проверки условий - от менее возможных форматов к более возможным
            if(isDouble(line)){
                print(Double.valueOf(line));
            } else if(isInteger(line)){
                print(Integer.valueOf(line));
            } else if(isShort(line)){
                print(Short.valueOf(line));
            } else {
                print(line);
            }

            line = bufferReader.readLine();
        }

        //закрыть считывающие потоки
        inputReader.close();;
        bufferReader.close();
    }

    //Проверка обладает ли строка всеми признакми Short
    private static boolean isShort(String line){
        return canBeConvertedToShort(line)  && 0 < Short.valueOf(line) && Short.valueOf(line) < 128;
    }

    //Проверка обладает ли строка всеми признакми Double
    private static boolean isDouble(String line){
        return canBeConvertedToDouble(line) && line.contains(".");
    }

    //Проверка обладает ли строка всеми признакми Integer
    private static boolean isInteger(String line){
        return canBeConvertedToInteger(line) && (Integer.valueOf(line) <= 0 || Integer.valueOf(line) >= 128);
    }

    //проверка можем ли мы сконвертировать строку в Short
    private static boolean canBeConvertedToShort(String line){
        try {
            Short.valueOf(line);
            return true;
        } catch (NumberFormatException exept){
            return false;
        }
    }

    //проверка можем ли мы сконвертировать строку в Double
    private static boolean canBeConvertedToDouble(String line){
        try {
            Double.valueOf(line);
            return true;
        } catch (NumberFormatException exept){
            return false;
        }
    }

    //проверка можем ли мы сконвертировать строку в Integer
    private static boolean canBeConvertedToInteger(String line){
        try {
            Integer.valueOf(line);
            return true;
        } catch (NumberFormatException exept){
            return false;
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
