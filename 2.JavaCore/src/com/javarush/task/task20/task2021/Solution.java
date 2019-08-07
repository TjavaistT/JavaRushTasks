package com.javarush.task.task20.task2021;

import java.io.*;

/* Хак заложенный в системе
private void writeObject и private void readObject(ObjectInputStream ois)
вызываются при сериализации поэтому в них необходимо поместить исключения

Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream obOutStr) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream ois) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
