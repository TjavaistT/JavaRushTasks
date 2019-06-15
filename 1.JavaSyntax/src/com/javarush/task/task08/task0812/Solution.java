package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.*;
import java.lang.*;

/* 0812
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // Тут валидатор особый - решение через Scaner не принимал не под каким предлогом
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int tempChain = 1;
        int chain = 1;

        for (int i = 0; i < 5; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 1; i < list.size(); i++){
            // ключевой момент - использовать equals при сравнении чисел в списке
            // равно - "==" - будет отдавать ошибку при числах больших 127 - это связано с сравнениями объектов типа Integer
            // это ярче видно в коде ниже
            /*Integer a = 5;
            Integer b = 5;
            Integer c = 200;
            Integer d = 200;

            if(a == b){
                System.out.println("a равно b");
            } else {
                System.out.println("a не равно b");
            }

            if(c == d){
                System.out.println("c равно d");
            } else {
                System.out.println("c не равно d");
            }*/

             if (list.get(i-1).equals(list.get(i))){
             // equals приводит объект Integer к примитивам int  и сравнивает
             //альтернатива - привести к int  вручную
             //if ((int)list.get(i-1) == (int)list.get(i)){
                tempChain++;
            } else {
                tempChain = 1;
            }

            if(tempChain > chain){
                chain = tempChain;
            }
        }

        System.out.println(chain);
    }
}