package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private boolean gender;
        private String specialization;
        private String specializationLevel;
        private int healthLevel;
        private int IQ;

        public static void main(String[] args) {

        }

        public Human(int age, boolean gender, String specialization, String specializationLevel, int healthLevel, int IQ) {
            this.age = age;
            this.gender = gender;
            this.specialization = specialization;
            this.specializationLevel = specializationLevel;
            this.healthLevel = healthLevel;
            this.IQ = IQ;
        }

        public Human(String specializationLevel, int healthLevel, int IQ) {
            this.specializationLevel = specializationLevel;
            this.healthLevel = healthLevel;
            this.IQ = IQ;
        }

        public Human(String specialization, String specializationLevel, int healthLevel) {
            this.specialization = specialization;
            this.specializationLevel = specializationLevel;
            this.healthLevel = healthLevel;
        }

        public Human(boolean gender, String specialization, String specializationLevel) {
            this.gender = gender;
            this.specialization = specialization;
            this.specializationLevel = specializationLevel;
        }

        public Human(int age, boolean gender, String specialization) {
            this.age = age;
            this.gender = gender;
            this.specialization = specialization;
        }

        public Human(int age, boolean gender) {
            this.age = age;
            this.gender = gender;
        }

        public Human(boolean gender, String specialization) {
            this.gender = gender;
            this.specialization = specialization;
        }

        public Human(String specialization, String specializationLevel) {
            this.specialization = specialization;
            this.specializationLevel = specializationLevel;
        }

        public Human(String specializationLevel, int healthLevel) {
            this.specializationLevel = specializationLevel;
            this.healthLevel = healthLevel;
        }

        public Human(int healthLevel, int IQ) {
            this.healthLevel = healthLevel;
            this.IQ = IQ;
        }
    }
}
