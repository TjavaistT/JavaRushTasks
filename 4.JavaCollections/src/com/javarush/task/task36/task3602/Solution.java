package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class expectedClass = null;
        //отфильтровываем из всех коллекций те, которые реализуют интерфейс List, являются статическими и приватными
        Class[] classes = Arrays.stream(Collections.class.getDeclaredClasses())
                            .filter(c -> List.class.isAssignableFrom(c)
                                        && Modifier.isStatic(c.getModifiers())
                                        && Modifier.isPrivate(c.getModifiers()))
                            .toArray(Class[]::new);

        //проверяем могут ли объекты этих классов в рамках интерфейса List находить элементы по классу
        for (Class clazz : classes) {
            List searchedObject;
            //попытка создать объекты
            try {
                Constructor constructor = clazz.getDeclaredConstructor(null);
                constructor.setAccessible(true);
                searchedObject = (List) constructor.newInstance();

            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {
                continue;
            }
            //в интерфейсе List только один метод отдает объекты по классу - "get"- его и проверяем
            try {
                searchedObject.get(0);
            } catch (IndexOutOfBoundsException except){
                expectedClass = searchedObject.getClass();
            }
        }

        return expectedClass;
    }
}
