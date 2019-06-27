package com.javarush.task.task16.task1630;

import java.io.*;

// Задача 1630 в память твоим погибшим нервам...

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName  = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private String fileName = "";
        private String content = "";

        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        public String getFileContent() {

            return content;
        }

        public void run() {

            setFileContent();

            System.out.println(getFileContent());
        }

        public void setFileContent() {
            StringBuilder contentSB = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
                while (reader.ready()){
                    contentSB.append(reader.readLine()).append(" ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.content = contentSB.toString();
        }
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

}
