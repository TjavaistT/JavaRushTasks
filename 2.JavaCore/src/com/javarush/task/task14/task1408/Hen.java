package com.javarush.task.task14.task1408;

abstract public class Hen {

    protected int countOfEggsPerMonth;

    protected String country;

    abstract public int getCountOfEggsPerMonth();

    public  String getDescription(){
        return  "Я - курица.";
    }

    public String getHen(Hen hen){
        return hen.country;
    }
}
