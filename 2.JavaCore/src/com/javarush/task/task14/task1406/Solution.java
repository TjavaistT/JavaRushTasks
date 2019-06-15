package com.javarush.task.task14.task1406;

/* Задача 1406
* объект самого младшего дочернего класса уже содержит в себе всех родителей (и ихние интерфейсы)
* поэтому можно не задумываясь приводить его к разным типам
*
* Объект родительского класса невозможно привести к дочернему (как не удивительно)
* потому что в нем нет дочерних методов
*
* т.е. легко можно отключать/подключать то, что уже есть. Но невозможно добавить то что уже есть.
*
Без ошибок
*/

public class Solution {
    public static void main(String[] args) {
        Object obj = new Jerry();

        Mouse mouse = (Mouse) obj;
        GrayMouse grayMouse = (GrayMouse) mouse;
        Jerry jerry = (Jerry) grayMouse;

        printClasses(obj, mouse, grayMouse, jerry);

    }

    public static void printClasses(Object obj, Mouse mouse, GrayMouse grayMouse, Jerry jerry) {
        System.out.println(jerry.getClass().getSimpleName());
        System.out.println(grayMouse.getClass().getSimpleName());
        System.out.println(mouse.getClass().getSimpleName());
        System.out.println(obj.getClass().getSimpleName());
    }

    static class Mouse {
    }

    static class GrayMouse extends Mouse {
    }

    static class Jerry extends GrayMouse {
    }
}
