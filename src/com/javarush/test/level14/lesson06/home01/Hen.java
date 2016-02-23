package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dmitry on 11.09.2015.
 */
public abstract class Hen implements Country
{
    abstract int getCountOfEggsPerMonth();

    String getDescription()
    {
        return "Я курица.";
    }

    ;
}
