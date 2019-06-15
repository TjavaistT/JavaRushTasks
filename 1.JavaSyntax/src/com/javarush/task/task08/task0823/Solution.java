package com.javarush.task.task08.task0823;

import java.io.*;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.trim;

/* Задачы 0823
мама моет какого-то Раму - папа в печали
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String resultString = "";
        //на идеоне не доимпортируется пакет import static jdk.nashorn.internal.objects.NativeString.trim;
        //который нужен для trim
        // но на джавраше в твоем локальном jdk пакет есть и джавраш засчитает решение
        String[] lines = s.trim().split("\\s+");

        for (int i = 0; i < lines.length; i++) {
            StringBuilder word = new StringBuilder(trim(lines[i]));
            word.setCharAt(0, Character.toUpperCase(word.charAt(0)));
            resultString += word.toString() + " ";
        }

        resultString = trim(resultString);

        System.out.print(resultString);
    }
}
