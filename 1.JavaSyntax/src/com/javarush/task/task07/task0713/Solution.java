package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 0713
Играем в Jолушку
Ни в сказке сказать, ни пером описать сколько времени провел в битве с валидатором
Как оказалось проще исправить чужое ошибочное решение, чем свое валидатору скормить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>(20);
        ArrayList<Integer> del3 = new ArrayList<Integer>();
        ArrayList<Integer> del2 = new ArrayList<Integer>();
        ArrayList<Integer> ost = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < list.size() ; i++) {
            Integer x = list.get(i);
            if (x % 2 == 0 & x % 3 == 0){
                del3.add(x);
                del2.add(x);
            }
            else if (x % 2 == 0) {
                del2.add(x);
            }
            else if (x % 3 == 0) {
                del3.add(x);
            }
            else {
                ost.add(x);
            }
        }
        printList(del3);
        printList(del2);
        printList(ost);
    }

    public static void printList(List<Integer> list) {
        for (Integer lista : list)
            System.out.println(lista);
    }
}
