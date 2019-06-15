package com.javarush.task.task11.task1123;

interface Climber{
    public void Climbing();
}

interface Programmer{
    public void Programming();
}

class JuliaPrib implements Climber, Programmer{
    public JuliaPrib() {
    }

    public static void main(String[] args){
    }

    public  void Climbing(){
        System.out.println("Лезть на трении");
    }

    public void Programming(){
        System.out.println("Писать криптографический код");
    }

    public void fryPancakes(){
        System.out.println("Жарить блинчики");
    }

    @Override
    public String toString() {
        return "Юлю";
    }
}

class Vaist implements Climber, Programmer{
    public Vaist() {
    }

    public static void main(String[] args){
    }

    public  void Climbing(){
        System.out.println("Лезть рывками");
    }

    public void Programming(){
        System.out.println("Писать юнит-тесты");
    }

    public void fry(Object Obj){
        System.out.println("Жарить " + Obj.toString());
    }
}
public class Live{
    public static void main(String[] args) {
        // --Сужение типа--//
        //Скалолазка Юля может лезть ни трении, как скалолазы
        Climber climberJuly = new JuliaPrib();
        climberJuly.Climbing();
        System.out.println();

        //но не может програмировать и жарить блинчики
        //climber.Programming(); - Х
        //climber.fryPancakes(); - Х

        //Юля программистка может писать функциональный код, как програмисты
        Programmer programmerJuly = new JuliaPrib();
        programmerJuly.Programming();
        System.out.println();

        //но не может лезть на трении и жарить блинчики
        // programmer.Climbing(); - Х
        //climber.fryPancakes(); - Х

        //и только Юля так может жарить Блинчики :) (и остальное-разное)
        JuliaPrib july = new JuliaPrib();
        july.fryPancakes();
        july.Climbing();
        july.Programming();
        System.out.println();

        //--Расширение типа--//
        //При желании скалолазная Юля может вспомнить как писать, код
        ((JuliaPrib) climberJuly).Programming();
        //програмистка вспомнит как она лезет по скалам
        ((JuliaPrib) programmerJuly).Climbing();
        //и даже воскресит свои навыки блинчикоделанья :)
        ((JuliaPrib) programmerJuly).fryPancakes();
        System.out.println();

        //--Уникальность Типа--//
        // Но! не сможет ничему этому научить меня так, как делаешь сама
        Vaist vaist = new Vaist();

        // хоть у меня есть познания в лазаньи
//        ((JuliaPrib) vaist).Climbing();    //код вызовет ошибку, хотя компилятор его разрешит
        // и программировании
//        ((JuliaPrib) vaist).Programming(); //код вызовет ошибку, хотя компилятор его разрешит
        //и даже че-то могу жарить
//        ((JuliaPrib) vaist).fryPancakes(); //код вызовет ошибку, хотя компилятор его разрешит

        //но все это делаю только в своем стиле
        vaist.Climbing();
        vaist.Programming();
//        vaist.fry();
    }
}
