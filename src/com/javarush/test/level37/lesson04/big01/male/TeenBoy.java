package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by Dmitry on 26.03.2016.
 */
public class TeenBoy implements Human
{
    public static final int  MAX_AGE = 19;

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + "{}";
    }
}
