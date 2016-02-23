package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dmitry on 11.09.2015.
 */
public class UkrainianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 3;
    }



    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
