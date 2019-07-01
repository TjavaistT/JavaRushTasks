package com.javarush.task.task17.task1711;

import java.util.*;
import java.text.*;

/* Run -> Edit Configurations -> Program Arguments
*
CRUD 2
*/
public class Solution {
    //для обеспечения правильной работы при многонитиевости
    // необходимо методы установления, получения и изменения списка сделать синхронизированными
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        try {
            //в зависимости от типа операции инициализируются разные свойства и различные операции
            //для удобства расширения инкапсулируем операции в отдельные объекты

            switch (args[0]){
                case "-c":
                    synchronized (allPeople) {
                        personsCreate(Arrays.copyOfRange(args, 1, args.length));
                    }
                        break;
                case "-u":
                    synchronized (allPeople) {
                        personsUpdate(Arrays.copyOfRange(args, 1, args.length));
                    }
                    break;
                case "-d":
                    synchronized (allPeople) {
                        personsDelete(Arrays.copyOfRange(args, 1, args.length));
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        personsInfo(Arrays.copyOfRange(args, 1, args.length));
                    }
                    break;
                default:
                    synchronized(allPeople){
                        throw new RuntimeException("Введеный параметр не соответствует ни одному типу операции");
                    }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* варианты запускаемых параметров
        -c name1 sex1 bd1 name2 sex2 bd2 ...
    */
    private static void personsCreate(String[] strings) throws ParseException {

        ArrayList<Person> createdPersons = new ArrayList<>();

        for( int i = 0; i < strings.length; i = i+3){
            String name = strings[i];
            Sex sex = createSex(strings[i+1]);

            Date birthday = createBirthday(strings[i + 2]);

            Person person = null;

            if (isMale(sex)) {
                person = Person.createMale(name, birthday);
            } else if (!isMale(sex)) {
                person = Person.createFemale(name, birthday);
            }

            createdPersons.add(person);
            updateAllPeople(person);
            System.out.println(allPeople.size()-1);
        }

    }

    /* варианты запускаемых параметров
      -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
     */
    private static void personsUpdate(String[] strings) throws ParseException {
        for (int i = 0; i < strings.length; i = i + 4) {
            int id = createId(strings[i]);
            String name = strings[i+1];
            Sex sex = createSex(strings[i + 2]);
            Date birthDate = createBirthday(strings[i+3]);

            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(sex);
            allPeople.get(id).setBirthDate(birthDate);
        }
    }

    /* варианты запускаемых параметров
        -d id1 id2 id3 id4 ...
     */
    private static void personsDelete (String[] strings) {
        for (String string : strings) {
            int id = createId(string);

            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDate(null);
        }
    }

    /* варианты запускаемых параметров
        -i id1 id2 id3 id4 ...
     */
    private static void personsInfo(String[] strings) {
        for (String string : strings) {
            int id = Integer.parseInt(string);
            Person person = allPeople.get(id);
            String strSex = "";
            if (person.getSex() == Sex.MALE) {
                strSex = "м";
            } else if (person.getSex() == Sex.FEMALE) {
                strSex = "ж";
            }

            System.out.println(person.getName() + " " + strSex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
        }
    }

    private static int createId(String id) {
        int result = -1;

        try {
            result = Integer.parseInt(id);

            if(result < 0){
                throw new RuntimeException("В массивах нет индекса меньше нуля - задавай верный параметр");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return result;
    }
    private static Sex createSex(String sex) throws RuntimeException {
        switch (sex){
            case "м":
                return Sex.MALE;
            case "ж":
                return Sex.FEMALE;
            default:
                throw new RuntimeException("Переданный параметр не соответствует мужскому или женскому полу");
        }
    }

    private static Date createBirthday(String bd) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
    }

    private static boolean isMale(Sex sex){
        return sex == Sex.MALE;
    }

    private static void setAllPeople(List<Person> people) {
        allPeople = people;
    }

    private static void updateAllPeople(Person persons){
        allPeople.add(persons);
    }

    private static List<Person> getAllPeople() {
        return allPeople;
    }
}