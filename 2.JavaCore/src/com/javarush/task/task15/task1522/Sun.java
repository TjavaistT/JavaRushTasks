package com.javarush.task.task15.task1522;

//не давать наследовать класс - объявляем класс как final
public final class Sun implements Planet{

    private static Sun instance;

    //не давать создавать объект - объвляем конструктор как private
    private Sun() {
    }


    public static Sun getInstance(){
        //не давать создавать второй экземпляр объекта - объявляем свойство с объектом private
        // и проверяем был ли объект уже создан
        if(Sun.instance == null){
            Sun.instance = new Sun();
        }

        return Sun.instance;
    }
}
