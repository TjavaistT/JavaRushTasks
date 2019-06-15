package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());
        int third = Integer.parseInt(reader.readLine());
        int middle = first;
        int temp;
        
        for(int i = 0; i < 3; i++ ){
            if(((first - second) * (first - third)) <= 0){
                middle = first;
            } 
            
            //меняем позиции чисел 1->2->3->1 и так по кругу 
            temp = first;
            first = second;
            second = third;
            third = temp;
        }
        
        System.out.println(middle);
    }
}
