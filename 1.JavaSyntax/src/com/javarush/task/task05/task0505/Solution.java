package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        Cat BlackJack = new Cat("BlackJack", 5, 8, 9);
        Cat WhiteFlash = new Cat("WhiteFlash", 4, 5, 12);
        Cat FishBond = new Cat("FishBond", 3, 4, 8);

        System.out.println(FishBond.fight(WhiteFlash));
        System.out.println(WhiteFlash.fight(BlackJack));
        System.out.println(BlackJack.fight(FishBond));
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int ageAdvantage = this.age > anotherCat.age ? 1 : 0;
            int weightAdvantage = this.weight > anotherCat.weight ? 1 : 0;
            int strengthAdvantage = this.strength > anotherCat.strength ? 1 : 0;

            int score = ageAdvantage + weightAdvantage + strengthAdvantage;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
