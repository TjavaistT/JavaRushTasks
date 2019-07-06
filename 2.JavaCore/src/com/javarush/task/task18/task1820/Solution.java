package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/
import java.io.*;
import java.util.*;
import java.lang.*;



public class Solution {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)) {
            String filenameFirst = scan.nextLine();
            String filenameSecond = scan.nextLine();

            List<Double> numbersOriginal = new ArrayList<>();
            StringBuilder numbersRounded = new StringBuilder();

            numbersOriginal = readFileToArray(filenameFirst, numbersOriginal);

            for (Double number : numbersOriginal) {
                int roundNumber = (int) Math.round(number);
                numbersRounded.append(roundNumber).append(" ");
            }

            FileOutputStream fos =  new FileOutputStream(filenameSecond);

            fos.write(numbersRounded.toString().getBytes());

            fos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //считать файл построчно в массив
    public static List<Double>  readFileToArray (String filePath, List<Double> readingContent) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File(filePath))));

        scanner.useLocale(Locale.ENGLISH);

        while (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            readingContent.add(number);
        }

        scanner.close();
        return readingContent;
    }
}
