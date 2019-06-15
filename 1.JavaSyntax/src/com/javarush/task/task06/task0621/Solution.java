package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  0621
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String male = "male";
        String female = "female";

        String grandfatherName = reader.readLine();
        Cat catGrandfather = new Cat(grandfatherName, male);

        String grandmatherName = reader.readLine();
        Cat catGrandmather = new Cat(grandmatherName, female);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, male, catGrandfather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, female, catGrandmather);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, male, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, female, catMother, catFather);

        System.out.println(catGrandfather);
        System.out.println(catGrandmather);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private String gender;
        private Cat parent1;
        private Cat parent2;

        Cat(String name, String gender, Cat parent1, Cat parent2) {
            //У кошачьего ребенка может быть два папы или две мамы
            //ну а что - очень современная кошачья семья...
            this.name = name;
            this.gender = gender;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }

        Cat(String name, String gender, Cat parent1) {
            this.name = name;
            this.gender = gender;
            this.parent1 = parent1;
        }

        Cat(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            String resultString = "";

            if (parent1 == null && parent2 == null) {
                resultString = "The cat's name is " + name + ", no mother, no father";
            } else if (parent1 != null && parent2 == null && parent1.gender == "male") {
                resultString = "The cat's name is " + name + ", no mother, father is " + parent1.name;
            } else if (parent1 != null && parent2 == null && parent1.gender == "female") {
                resultString = "The cat's name is " + name + ", mother is " + parent1.name + ", no father";
            } else {
                String aboutFirstParent = "";
                String aboutSecondParent = "";

                switch (parent2.gender) {
                    case "female":
                        aboutSecondParent = ", mother is " + parent2.name;
                        break;
                    case "male":
                        aboutSecondParent = ", father is " + parent2.name;
                        break;
                    default:
                        break;
                }

                switch (parent1.gender) {
                    case "female":
                        aboutFirstParent = ", mother is " + parent1.name;
                        break;
                    case "male":
                        aboutFirstParent = ", father is " + parent1.name;
                        break;
                    default:
                        break;
                }

                resultString = "The cat's name is " + name + aboutFirstParent + aboutSecondParent;
            }

            return resultString;

        }
    }
}