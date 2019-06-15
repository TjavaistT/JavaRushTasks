package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen{

    public BelarusianHen(){
        countOfEggsPerMonth = 4;
        country = Country.BELARUS;
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
