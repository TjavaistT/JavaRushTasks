package com.javarush.task.task07.task0718;

import java.io.*;
import java.util.*;

/* 0718
В этой задаче хитрое условие - проверить на упорядоченность
нужно просто поймать момент когда следующая строка станет больше предыдущей - и все :)
*
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = initalizeArray(10);
        String indexRebelliousString = null;

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(1);

            if (list.get(i+1).length() < list.get(i).length()) {
                indexRebelliousString =  i + 1 + "";
                break;
            }
        }

        if(indexRebelliousString != null){
            System.out.println(indexRebelliousString);
        }
    }

    private static ArrayList<String> initalizeArray(int count){
        ArrayList<String> list = new ArrayList<String>(count);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < count; i++){
            list.add(scan.nextLine());

        }

        return list;
    }
}


