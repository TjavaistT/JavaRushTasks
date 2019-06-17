package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    private int i;
    private String s;

    public Solution() {
    }

    protected Solution(int i) {
        this.i = i;
    }

    private Solution(String s) {
        this.s = s;
    }

    Solution(int i, String s){
        this.i = i;
        this.s = s;
    }



    public static void main(String[] args) {

    }
}

