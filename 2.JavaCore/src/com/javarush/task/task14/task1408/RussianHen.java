package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{

    public RussianHen(){
        countOfEggsPerMonth = 1;
        country = Country.RUSSIA;
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
