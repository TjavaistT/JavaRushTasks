package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/*  0814 - Задача с подвохом - в коллекции должны быть только уникальные значения
* т.е. перед добавлением цифру необходисо проверять не содержится ли уже такая в коллекции
*
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<>();
        int count = 20;
        Random random = new Random();

        for (int i = 0; i < count; ) {
            Integer element = random.nextInt(99);
            // в коллекции нет одинаковых, все особенные
            // любая супергеройская команда - коллекция :)
            if(!set.contains(element)){
                set.add(element);
                i++;
            }
        }

        return set;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        set.removeIf(o -> o > 10);
        return set;
    }

    public static void main(String[] args) {
        HashSet set = createSet();
//        set.forEach(System.out::println);
        removeAllNumbersGreaterThan10(set);
//        System.out.println("====================================");
//        set.forEach(System.out::println);
    }
}
