package com.javarush.task.task20.task2018;

import java.io.*;
import java.lang.*;

/* задача 2018 о тонкостях
оставлю здесь чей-то полезный комментарий

В задаче нужно использовать следующие факты:
1) Объект нестатического внутреннего класса не может существовать без объекта внешнего класса,
а значит при сериализации объекта класса В сериализуется и связанный с ним объект класса Solution.
Соответственно, для сериализации объекта класса В нужно, чтобы Solution был также Serializable.
Валидатор, кстати, это не проверяет, но без этого код не будет у вас работать.
2) При десериализации "по умолчанию" (равно как и методом defaultReadObject) выполняется конструктор без параметров первого
(в иерархии наследования) несериализованного родительского класса. Т.е. если у класса А нет конструктора без параметров, то будет ошибка.
Валидатор это не проверяет.
3) При десериализации объекта класса В выполняется конструктор без параметров класса А,
который (даже если он пустой) инициализирует переменные класса. В результате в переменной name будет "А" вместо "АВ2В2".
Соответственно поле name приходиться сериализовать вручную.
Валидатор это проверяет.

Найти ошибки
*/
public class Solution  implements  Serializable{
    public static class A {

        protected String nameA = "A";

        public A() {
        }

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        //хак заложеный в системе, нда и так бывает...
        private void writeObject(ObjectOutputStream ous) throws Exception {
            ous.defaultWriteObject();
            ous.writeObject(nameA);
        }

        private void readObject(ObjectInputStream ois) throws Exception {
            ois.defaultReadObject();
            nameA = (String)ois.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
