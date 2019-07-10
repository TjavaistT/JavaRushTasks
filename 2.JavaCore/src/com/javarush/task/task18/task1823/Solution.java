package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;
import java.lang.*;
/* Задача 1823
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        try (
            Scanner scanConsole = new Scanner(System.in);
        ){
            String filename;
            //удобная сокращенная запись
            while (!(filename = scanConsole.nextLine()).equals("exit")) {
                Thread t = new ReadThread(filename);
                threads.add(t);
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {

            try (
                 FileInputStream fileInpStream = new FileInputStream(fileName)
            ){
                byte[] contentFile = new byte[fileInpStream.available()];
                int[] bytesStatistic = new int[256];
                fileInpStream.read(contentFile);

                for (byte currentByte : contentFile) {
                    bytesStatistic[currentByte]++;
                }

                int maxByteCount = Arrays.stream(bytesStatistic).max().getAsInt();

                for (int currentByte = 0; currentByte < 256; currentByte++) {
                    if(bytesStatistic[currentByte] == maxByteCount){
                        Integer mostPopularByte = currentByte;
                        resultMap.put(fileName, mostPopularByte);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}