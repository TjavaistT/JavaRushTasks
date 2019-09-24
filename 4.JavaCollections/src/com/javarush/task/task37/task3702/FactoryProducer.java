package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

import static com.javarush.task.task37.task3702.FactoryProducer.HumanFactoryType.FEMALE;
import static com.javarush.task.task37.task3702.FactoryProducer.HumanFactoryType.MALE;

public class FactoryProducer {

    public static AbstractFactory getFactory(HumanFactoryType gender) {
        AbstractFactory factory = null;

        if(gender == MALE){
            factory = new MaleFactory();
        } else if (gender == FEMALE){
            factory = new FemaleFactory();
        }

        return factory;
    }

    enum HumanFactoryType{
        MALE,
        FEMALE
    }
}
