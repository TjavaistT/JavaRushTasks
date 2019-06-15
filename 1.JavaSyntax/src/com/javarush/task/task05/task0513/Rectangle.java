package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top;
    int left;
    int width;
    int height;

    public static void main(String[] args) {

    }

    public void initialize(int top, int left, int line){
        this.top = top;
        this.left = left;
        this.height = this.width = line;
    }

    public void initialize(Rectangle rect){
        this.top = rect.top;
        this.left = rect.left;
        this.height = rect.height;
        this.width = rect.width;
    }

    public void initialize(int top, int left, int height, int width){
        this.initialize(top, left);
        this.width = width;
    }

    public void initialize(int top, int left){
        this.top = top;
        this.left = left;
    }
}
