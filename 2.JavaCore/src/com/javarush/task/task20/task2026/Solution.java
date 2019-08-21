package com.javarush.task.task20.task2026;

/* Задача 2026
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] area) {
        int rectangleCount = 0;
        int[] coordinates;

        //слева напрово найти ближайший верхний левый угол
        while((coordinates = getNextHighLeftCorner(area))!= null){
            rectangleCount++;
            //исключить прямоугольник
            area = excludeRectangle(area, coordinates);
        }

        return rectangleCount;
    }

    /*
    * Исключение прямоугольника из поля, начиная с правого верхнего угла
     */
    public static byte[][] excludeRectangle(byte[][] area, int[] coordinates) {
        int jLeftBorder = coordinates[1];
        //необходимо запомнить в каком столбце начинается прямоугольник
        //чтобы возвращатся к нему, когда меняем строку

        while(true){
            //если ячейка в пределах поля и значение ячейки равно еденице - значит это кусок прямоугольника
            if(isCeilInFieldAndContainsOne(area, coordinates[0], coordinates[1])) {
                clearAndMoveRight(area, coordinates);
                //если вышли за пределы поля справа или закончились заполненные поля - спускаемся на строку ниже
            } else {
                //если двигатся вниз
                moveDown(coordinates, jLeftBorder);
                //если невозможно
                //если закончились строки
                //или эта ячейка пустая то и прямоугольник закончился - то остановится
                if(!isCeilInFieldAndContainsOne(area, coordinates[0], coordinates[1])) break;
            }
        }

        return area;
    }

    private static void clearAndMoveRight(byte[][] area, int[] coordinates) {
        //стираем этот кусок
        clearCeil(area, coordinates[0], coordinates[1]);
        //и продвигаемся вправо по ряду для поиска новых кусков
        coordinates[1]++;
    }

    private static boolean isCeilInFieldAndContainsOne(byte[][] area, int i, int j) {
        return isCoordinatesInField(area, i, j) && isCeilContainsOne(area, i, j);
    }

    private static void moveDown(int[] coordinates, int jLeftBorder) {
        coordinates[0]++;
        coordinates[1] = jLeftBorder;
    }

    private static boolean isWidthInField(byte[][] area, int j) {
        return j < area[0].length - 1;
    }

    private static byte[][] clearCeil(byte[][] area, int i, int j) {
        area[i][j] = 0;
        return area;
    }

    private static boolean isCeilContainsOne(byte[][] area, int i, int j) {
        return area[i][j] == 1;
    }

    private static boolean isCoordinatesInField(byte[][] area, int i, int j) {
        return i <= area.length-1 && j <=area[0].length-1;
    }

    public static int[] getNextHighLeftCorner(byte[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] == 1) return new int[]{i, j};
            }
        }

        return null;
    }
}
