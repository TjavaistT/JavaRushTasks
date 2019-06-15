package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen{

    public UkrainianHen(){
        countOfEggsPerMonth = 2;
        country = Country.UKRAINE;
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return this.countOfEggsPerMonth;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+this.country+". Я несу "+this.countOfEggsPerMonth+" яиц в месяц.";
    }
}
