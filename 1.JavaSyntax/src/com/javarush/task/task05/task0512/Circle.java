package com.javarush.task.task05.task0512;

/* 
Создать класс Circle
*/

public class Circle {
    int centerX;
    int centerY;
    int radius;
    int width;
    int color;

    public static void main(String[] args) {

    }

    public void initialize(int centerX, int centerY, int radius){
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public void initialize(int centerX, int centerY, int radius, int width){
        this.initialize(centerX, centerY, radius);
        this.width = width;
    }

    public void initialize(int centerX, int centerY, int radius, int width, int color){
        this.initialize(centerX, centerY, radius, width);
        this.color = color;
    }
}
