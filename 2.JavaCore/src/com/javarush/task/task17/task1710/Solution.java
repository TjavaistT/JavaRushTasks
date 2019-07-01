package com.javarush.task.task17.task1710;

import java.text.*;
import java.util.*;

/* Внимание: программа запускается с НАБОРОМ ПАРАМЕТРОВ (не забудь рассказать)
 * Столько кода нужно для упрощения дальнейшей поддержки (чтоб было проще что-нибудь сделать на основе этой задачи)
CRUD
*/

public class Solution {

    public enum Operations {
        CREATE,
        UPDATE,
        DELETE,
        INFO
    }

    private static Operations currentOperation;

    private static Integer currentPersonId = null; //важно сделать id null - иначе по умолчанию он станет нулем
    // и в если параметр не введен программа не упадет как должна, а тихо обработает 0-го в списке

    private static String currentPersonName;

    private static Sex currentPersonSex;

    private static Date currentPersonBirthDate;

    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        /* варианты запускаемых параметров
        -c name sex bd
        -u id name sex bd
        -d id
        -i id
         */

        try {
            //параметры там сам как-то определятся - можно не забивать этим голову
            initCurrentParams(args);

            switch (currentOperation){
                case CREATE:
                    int id = createAndAddPeople(currentPersonName, currentPersonSex, currentPersonBirthDate);
                    System.out.println(id);
                    break;
                case UPDATE:
                    updatePeople(currentPersonId, currentPersonName, currentPersonSex, currentPersonBirthDate);
                    break;
                case DELETE:
                    deletePeople(currentPersonId);
                    break;
                case INFO:
                    infoAboutPeople(currentPersonId);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void infoAboutPeople(int currentPersonId) {
        Person person = allPeople.get(currentPersonId);
        String strSex = "";
        if (person.getSex() == Sex.MALE) {
            strSex = "м";
        } else if (person.getSex() == Sex.FEMALE){
            strSex = "ж";
        }

        System.out.println(person.getName() + " " + strSex + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate()));
    }

    public static int createAndAddPeople(String name, Sex sex, Date bd) throws RuntimeException {
        int lastElementNumber = allPeople.size();
        switch (sex) {
            case MALE:
                allPeople.add(lastElementNumber, Person.createMale(name, bd));
            break;
            case FEMALE:
                allPeople.add(lastElementNumber, Person.createFemale(name, bd));
            break;
        }

        return lastElementNumber;
    }

    private static void updatePeople(int currentPersonId, String currentPersonName, Sex currentPersonSex, Date currentPersonBirthDate) {
        Person newPerson = null;
        switch (currentPersonSex) {
            case MALE:
                newPerson = Person.createMale(currentPersonName, currentPersonBirthDate);
                break;
            case FEMALE:
                newPerson = Person.createFemale(currentPersonName, currentPersonBirthDate);
                break;
        }

        allPeople.set(currentPersonId, newPerson);
    }

    private static void deletePeople(int currentPersonId) {
        allPeople.get(currentPersonId).setName(null);
        allPeople.get(currentPersonId).setSex(null);
        allPeople.get(currentPersonId).setBirthDate(null);
    }

    private static void initCurrentParams(String[] args) throws ParseException, RuntimeException {
        switch (args.length){
            case 5:
                initCurrentParams(args[0], args[1], args[2], args[3], args[4]);
            break;
            case 4:
                initCurrentParams(args[0], args[1], args[2], args[3]);
                break;
            case 2:
                initCurrentParams(args[0], args[1]);
                break;
            default:
                throw new RuntimeException("В программу передано не верное количество параметров");
        }
    }

    private static void initCurrentParams(String operation, String id, String name, String sex, String bd) throws RuntimeException, ParseException {
        initCurrentParams(operation, id);
        currentPersonName = createName(name);
        currentPersonSex = createSex(sex);//вам не зачем знать детали реализации
        currentPersonBirthDate = createBirthday(bd);
    }

    private static void initCurrentParams(String operation, String name, String sex, String bd) throws RuntimeException, ParseException {
        initCurrentParams(operation);
        currentPersonName = createName(name);
        currentPersonSex = createSex(sex);//вам не зачем знать детали реализации
        currentPersonBirthDate = createBirthday(bd);
    }

    private static void initCurrentParams(String operation, String id) {
        initCurrentParams(operation);
        currentPersonId = createId(id);
    }
    private static void initCurrentParams(String operation) {
        currentOperation = createOperation(operation);
    }

    private static Operations createOperation(String operation) {
        Operations result = null;

        switch (operation){
            case "-c":
                result = Operations.CREATE;
                break;
            case "-u":
                result = Operations.UPDATE;
                break;
            case "-d":
                result = Operations.DELETE;
                break;
            case "-i":
                result = Operations.INFO;
                break;
            default:
                throw new RuntimeException("Введеный параметр не соответствует ни одному типу операции");
        }

        return result;
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

    private static String createName(String name) {
        return name;
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

    private static boolean isMale(String sex) throws RuntimeException {
        if(sex.equals("м")){
            return true;
        } else if(sex.equals("ж")){
            return false;
        } else {
            String[] error = new String[1];
            throw new RuntimeException("Логическая ошибка - пол не мужской и не женский");
        }
    }
}
