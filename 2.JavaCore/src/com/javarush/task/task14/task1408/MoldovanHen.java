package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{

    public MoldovanHen(){
        countOfEggsPerMonth = 3;
        country = Country.MOLDOVA;
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
