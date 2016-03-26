package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.female.FemaleFactory;
import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Dmitry on 26.03.2016.
 */
public class FactoryProducer
{
    public static AbstractFactory getFactory(HumanFactoryType type)
    {
        switch (type){
            case MALE:
                return new MaleFactory();
            case FEMALE:
                return new FemaleFactory();
        }
        return null;
    }

    public static enum HumanFactoryType
    {
        MALE, FEMALE
    }
}
