package com.javarush.task.task15.task1522;

public final class Sun implements Planet{

    private static Sun instance;

    private Sun() {
    }

    public static Sun getInstance(){
        if(Sun.instance == null){
            Sun.instance = new Sun();
        }

        return Sun.instance;
    }
}
