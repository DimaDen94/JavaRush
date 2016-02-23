package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Dmitry on 02.12.2015.
 */
public class Singleton
{

    static Singleton INSTANCE = null;
    private Singleton() {}

    static Singleton getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

}
