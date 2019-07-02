package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            //считать имена файлов
            String file1 = "";
            String file2 = "";
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

                file1 = bufferedReader.readLine();
                file2 = bufferedReader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

            //считать allLines
            readFileToArray(file1, allLines);

            //считать forRemoveLines
            readFileToArray(file2, forRemoveLines);

            (new Solution()).joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    //считать файл построчно в массив
    public static void readFileToArray(String filePath, List<String> readingContent){
        try (Scanner scan = new Scanner(new BufferedReader(new FileReader(new File(filePath))))){
            while (scan.hasNextLine()){
                readingContent.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}