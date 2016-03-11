package com.javarush.test.level32.lesson15.big01;

/**
 * Created by Dmitry on 11.03.2016.
 */
public class ExceptionHandler extends Exception
{
    public static void log(Exception e){
        System.out.println(e.toString());
    }
}
