package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Objects;

/* Задача 1319
Писатель в файл с консоли
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String text = "", line = "";

        InputStreamReader readerIS = null;
        BufferedReader reader = null;

        OutputStreamWriter writer = null;
        BufferedWriter bufferedWriter = null;

        String filePath = null;

        try {
            readerIS = new InputStreamReader(System.in);
            reader = new BufferedReader(readerIS);
            filePath = reader.readLine();
                while (true){

                    line = reader.readLine();
                    text += line + "\n";

                    if (line.equals("exit")) {
                            break;
                        }

                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(Objects.requireNonNull(filePath));
        OutputStream outputStream = new FileOutputStream(file);
        writer = new OutputStreamWriter(outputStream);
        bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write(text);

        readerIS.close();
        reader.close();
        bufferedWriter.close();
        writer.close();
    }
}
