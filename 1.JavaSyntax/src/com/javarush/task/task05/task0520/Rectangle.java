package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top;
    int left;
    int width;
    int height;

    public static void main(String[] args) {

    }

    public Rectangle(int top, int left){
        this.top = top;
        this.left = left;
    }

    public Rectangle(int top, int left, int line){
        this(top, left);
        this.height = this.width = line;
    }

    public Rectangle(Rectangle rect){
        this(rect.top, rect.left);
        this.height = rect.height;
        this.width = rect.width;
    }

    public Rectangle(int top, int left, int height, int width){
        this(top, left);
        this.height = height;
        this.width = width;
    }
}
