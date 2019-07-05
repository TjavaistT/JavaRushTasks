package com.javarush.task.task18.task1819;

/* Чужое решение
* Сам решил через FileRandomAccess - но валидатор не принимает
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list=new ArrayList<>();
        String file1=buf.readLine();
        String file2=buf.readLine();
        FileInputStream inputStream = new FileInputStream(new File(file1));//читаем из Text2-го файла

        //записываем в Text2-го файла файлт Text1

        FileInputStream inputStream2=new FileInputStream(file2);//запись  в Text1-й фйл
        while (inputStream.available() > 0) {//читаем из 2го файла, который ввели
            int a=inputStream.read();
            list.add(a);//сохраняем значени Text2,и нам теперь нужно в него записать Text1

        }
        FileOutputStream outputStream=new FileOutputStream(new File(file1));
        while (inputStream2.available() > 0) {
            int a=inputStream2.read();
            outputStream.write(a);

        }

        for (int i=0; i < list.size(); i++) {
            outputStream.write(list.get(i));
        }


        inputStream.close();
        inputStream2.close();
        outputStream.close();
        buf.close();


    }


}