package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

/* Задача 1916
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static int indexFirstFile = 0;

    public static int indexSecondFile = 0;

    public static void main(String[] args) {
        try (
                BufferedReader scanConsole = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileBufferReader1 = new BufferedReader(new FileReader(scanConsole.readLine()));
                BufferedReader fileBufferReader2 = new BufferedReader(new FileReader(scanConsole.readLine()))
        ){
            List<String> linesFile1 = fileBufferReader1.lines().collect(Collectors.toList());

            List<String> linesFile2 = fileBufferReader2.lines().collect(Collectors.toList());

            String firstLineFirstFile = getLine(linesFile1, indexFirstFile);
            String firstLineSecondFile = getLine(linesFile2, indexSecondFile);

            while(firstLineFirstFile != null || firstLineSecondFile != null){
                String secondLineFirstFile = getLine(linesFile1, indexFirstFile + 1);
                String secondLineSecondFile = getLine(linesFile2, indexSecondFile + 1);

                //проверка для конца файла - если в одном файле закончатся элементы, а в другом останутся
                if(firstLineFirstFile == null){
                    setAddedLine(firstLineSecondFile);
                } else if(firstLineSecondFile == null){
                    setRemovedLine(firstLineFirstFile);
                }
                //Проверка для заполненной части файла

                //по условию задачи у нас встречаются неизмененные строки не реже чем через одну строку
                //а также в файлах нет пропуска строк
                //другими словами у нас може быть только три ситуации
                // Файл1           Файл2

                //строка1         строка1    -   неизменные строки

                //строка1         строка2    - строка1 была удалена в файле2  можно представить так //строка1
                //строка2         строкаПофиг(но не строка1 по условию задачи)                      //строка2   строка2

                //строка1         строка2    - строка2 была добавлена в файл2 можно предстивить так //          строка2
                //строкаПофиг     строка1                                                           //строка1   строка1
                //(но не строка2)

                // Проверка неизменности строк
                // х     х
                else if(isSame(firstLineFirstFile, firstLineSecondFile)){
                    setSameLine(firstLineFirstFile);

                //Проверка удалена ли строка
                // 0          х
                // х
                } else if(isRemove(secondLineFirstFile, firstLineSecondFile)){
                    setRemovedLine(firstLineFirstFile);

                //Проверка добавлена ли строка
                // х          0
                //            х
                } else if (isAdded(firstLineFirstFile, secondLineSecondFile)){
                    setAddedLine(firstLineSecondFile);
                }

                firstLineFirstFile = getLine(linesFile1, indexFirstFile);
                firstLineSecondFile = getLine(linesFile2, indexSecondFile);
            }

            lines.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setSameLine(String line) {
        lines.add(new LineItem(Type.SAME, line));
        indexFirstFile++;
        indexSecondFile++;
    }

    private static void setAddedLine(String firstLineSecondFile) {
        lines.add(new LineItem(Type.ADDED, firstLineSecondFile));
        indexSecondFile++;
    }

    private static void setRemovedLine(String firstLineFirstFile) {
        lines.add(new LineItem(Type.REMOVED, firstLineFirstFile));
        indexFirstFile++;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.line + " " + this.type;
        }

    }
    private static String getLine(List<String> linesOfFile, int indexLine) {
        try{
            return linesOfFile.get(indexLine);
        } catch (IndexOutOfBoundsException|NullPointerException ignored){
            return null;
        }
    }

    private static boolean isSame(String line1, String line2) {
        return isEqualsTrim(line1, line2);
    }

    private static boolean isRemove(String line1, String line2) {
        return isEqualsTrim(line1, line2);
    }

    private static boolean isAdded(String line1, String line2) {
        return isEqualsTrim(line1, line2);
    }

    private static boolean isEqualsTrim(String line1, String line2) {
        return line1.trim().equals(line2.trim());
    }

}
