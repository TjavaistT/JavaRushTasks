package com.javarush.task.task15.task1522;

public final class Moon implements Planet {

    private static Moon instance;

    private Moon() {
    }

    public static Moon getInstance(){
        if(Moon.instance == null){
            Moon.instance = new Moon();
        }

        return Moon.instance;
    }
}
