package com.javarush.task.task15.task1505;

import java.util.ArrayList;
import java.util.List;

/* Задача 1505 - здесь можно замудрится как я с новым типом объекта и Т.Д
 * но решение простое
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public static class ContainsBones{

        private String containsBones;

        public ContainsBones(boolean containsBones) {
            if(containsBones) {
                this.setContainsBones("Yes");
            } else {
                this.setContainsBones("No");
            }
        }

        public String getContainsBones() {
            return containsBones;
        }

        public void setContainsBones(String containsBones) {
            this.containsBones = containsBones;
        }
    }

    public static interface LivingPart {
        Object containsBones();

    }
    public static class BodyPart implements LivingPart {

        private String name;

        public BodyPart(String name) {
            this.name = name;
        }

        public Object containsBones() {
            return "Yes";
        }
        public String toString() {
            return containsBones() ==  "Yes" ? name + " содержит кости" : name + " не содержит кости";
        }

    }

    public static class Finger extends BodyPart {
        private boolean isArtificial;

        public Finger(String name, boolean isArtificial) {
            super(name);
            this.isArtificial = isArtificial;
        }

        public Object containsBones() {
            return super.containsBones() == "Yes" && !isArtificial ? "Yes": "No";
        }
    }

    public static void main(String[] args) {
        printlnFingers();
        printlnBodyParts();
        printlnLivingParts();
    }

    private static void printlnLivingParts() {
        System.out.println(new BodyPart("Рука").containsBones());
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Большой", true));
        fingers.add(new Finger("Указательный", true));
        fingers.add(new Finger("Средний", true));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", true));
        System.out.println(fingers.toString());
    }
}

