package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//У этой задачи рекордный показатель средних попыток - выше 6-ти - комментарии излишни
// если останавливать четвертую нить через interrupt - это немноого дольше, чем булевой переменной в том же классе нити
// вот на эта задержка и ломат мозг валидатору

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread4());
        threads.add(new Thread(new Thread5()));
    }

    public static void main(String[] args) {
    }

    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            int i = 1;
            while (true){
                i++;
                i++;
                i--;
                i--;
            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    private static class Thread3 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Thread4 extends Thread implements Message {
        boolean repeat = true;

        @Override
        public void showWarning() {
            repeat = false;
        }

        @Override
        public void run() {
            while (repeat);
        }
    }

    private static class Thread5 implements Runnable {

        @Override
        public void run() {
            String string = "";
            Integer sum = 0;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (!string.equals("N")) {
                try {
                    string = bufferedReader.readLine();
                    sum += Integer.parseInt(string);

                } catch (NumberFormatException|IOException e) {

                }
            }
            System.out.println(sum);
        }
    }
}