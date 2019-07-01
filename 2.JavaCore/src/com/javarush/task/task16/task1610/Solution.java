package com.javarush.task.task16.task1610;

/* Задача 1610 - роди, собери, накорми... хорошо, что я не кошка
Расставь вызовы методов join()
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //между кошками нет никакой связи - не трогаем здесь ничего
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Пушинка");
    }

    private static void investigateWorld() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) {
            super(name);
            kitten1 = new Kitten("Котенок 1, мама - " + getName());
            kitten2 = new Kitten("Котенок 2, мама - " + getName());
            start();
        }

        public void run() {
            System.out.println(getName() + " родила 2 котенка");
            try {
                // а вот котят можно собирать только после того как расползутся
                // ждем пока каждый найдет себе угол, чтоб туда забурится
                // и потом уже можно собирать беглецов
                initAllKittens();
                kitten1.join();
                kitten2.join();
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start();
            kitten2.start();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + ", вылез из корзинки");
            investigateWorld();
        }
    }
}
