package com.javarush.test.level37.lesson04.big01.female;

import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by Dmitry on 26.03.2016.
 */
public class TeenGirl implements Human
{
    public static final int  MAX_AGE = 19;

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + "{}";
    }
}
