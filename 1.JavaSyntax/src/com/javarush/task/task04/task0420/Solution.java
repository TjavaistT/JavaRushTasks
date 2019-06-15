package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

class Solution{
    private long[] a;   //ссылка на массив
    private int elems;  //количество элементов в массиве
    private boolean swap; //флаг отображающий что была сделана перестановка

    public Solution(int max){    //конструктор класса
        a = new long[max];          //создание массива размером max
        elems = 0;                  //при создании массив содержит 0 элементов
    }

    public static void main(String[] args) {
        try {

            int max = 3;
            Solution array = new Solution(max); //Создаем массив array на 5 элементов
            String line;
            int i = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (i < max) {
                array.into(Integer.valueOf(reader.readLine()));
                i++;
            }

            array.bubbleSorter();       //ИСПОЛЬЗУЕМ ПУЗЫРЬКОВУЮ СОРТИРОВКУ
            array.printer();            //снова выводим отсортированный йсписок
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void into(long value){   //метод вставки элемента в массив
        a[elems] = value;           //вставка value в массив a
        elems++;                    //размер массива увеличивается
    }

    public void printer(){          //метод вывода массива в консоль
        for (int i = 0; i < elems; i++){    //для каждого элемента в массиве
            System.out.print(a[i] + " ");   //вывести в консоль
        }
    }

    private boolean toSwap(int first, int second){ //метод меняет местами пару чисел массива
        long dummy = a[first];      //во временную переменную помещаем первый элемент
        a[first] = a[second];       //на место первого ставим второй элемент
        a[second] = dummy;          //вместо второго элемента пишем первый из временной памяти

        return true;                //была совершена перестановка
    }

    public void bubbleSorter(){     //МЕТОД ПУЗЫРЬКОВОЙ СОРТИРОВКИ
        swap = true; //была ли хотя бы одна перестановка за последнюю итерацию
        for (int out = elems - 1; out >= 1; out--){  //Внешний цикл

            //оптимизация алгоритма
            //если за последнюю итерацию перестановок не было - то массив отсортирован
            if(!swap) {
                return;
            }
            swap = false;

            for (int in = 0; in < out; in++){       //Внутренний цикл
                if(a[in] < a[in + 1])               //Если порядок элементов нарушен
                    swap = toSwap(in, in + 1);             //вызвать метод, меняющий местами
            }
        }
    }
}