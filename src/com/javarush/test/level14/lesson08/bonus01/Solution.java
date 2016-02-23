package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileNotFoundException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        exceptions.add( new NullPointerException() );
        exceptions.add( new IndexOutOfBoundsException() );
        exceptions.add( new IllegalArgumentException() );
        exceptions.add( new FileNotFoundException() );
        exceptions.add( new InstantiationException() );
        exceptions.add( new BufferOverflowException() );
        exceptions.add( new IllegalAccessException() );
        exceptions.add( new NoSuchFieldException() );
        exceptions.add( new BufferUnderflowException() );
        //Add your code here

    }
}
