package com.javarush.task.task15.task1530;

// В джавараше не досказали про хуки,
//ты их встречала в вордпрессе, битриксе, джумле, Уии, Симфонии... везде кароч
// и когда будешь делать свой проект-фреймворк, они тебе потребуются,
// когда потребуется давать возможность другим разаработчикам-клиентам изменять твой код
abstract public class DrinkMaker {
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink(){
        //хуки до начала алгоритма
//        beforeMakeDrink();

        //хуки до шага алгоритма
//        beforeGetRightCup();
        getRightCup();
        //хуки после шага алгоритма
//        afterGetRightCup();

//        beforePutIngredient();
        putIngredient();
//        afterPutIngredient();

//        beforePour();
        pour();
//        afterPour();

//        //хуки после конца алгоритма
//        afterMakeDrink();
    }

//    public void afterMakeDrink() {
//    }
//
//    public void afterPour() {
//    }
//
//    public void beforePour() {
//    }
//
//    public void afterPutIngredient() {
//    }
//
//    public void beforePutIngredient() {
//    }
//
//    public void afterGetRightCup() {
//    }
//
//    public void beforeMakeDrink() {
//    }
//
//    public void beforeGetRightCup() {
//
//    }
}
