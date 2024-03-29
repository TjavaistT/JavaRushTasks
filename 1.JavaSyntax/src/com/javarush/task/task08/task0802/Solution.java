package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap <String, String> map = new HashMap<String, String>();

        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");

        Iterator<HashMap.Entry<String, String>> vegansIterator = map.entrySet().iterator();

        while (vegansIterator.hasNext()){
            HashMap.Entry<String, String> pair = vegansIterator.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
