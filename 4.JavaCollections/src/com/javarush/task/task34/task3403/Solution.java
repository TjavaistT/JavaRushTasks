package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.recurse(132);
    }

    public void recurse(int n) {
        for (int i = 2; i <= n; i++) {
            if(n % i == 0){
                System.out.println(i);
                recurse(n/i);
                break;
            }
        }
    }
}
