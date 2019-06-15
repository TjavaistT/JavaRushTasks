package com.javarush.task.task15.task1506;

/* Задача 1506 примитивная задача, если прочитать внимательно требования
* но соль в другом - если присмотрется, на этой здачи видна магия преобразования типов в Java
* 1. Сначала примитив ищет свой метод
* 2. Потом расширяется: byte->short->int->long->float->double.
* 3. Если не найдёт подходящий метод, то потом упаковывается в свой объект (int->Integer , short -> Short и.т.д) и ищет именно его.
* 5. Если не находит, преобразовывается просто в Объект
* 6. Если и потом не находит то, сужается (уже будучи объектом) до Number, и затем до Object.
Что-то лишнее
*/

public class Solution {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print((int) 1);
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

//    public static void print(int i) {
//        System.out.println("Это Integer");
//    }

//    public static void print(Short i) {
//        System.out.println("Это Object");
//    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

//    public static void print(Double i) {
//        System.out.println("Это double");
//    }
//
//    public static void print(float i) {
//        System.out.println("Это Double");
//    }
}
