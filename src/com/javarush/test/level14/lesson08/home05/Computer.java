package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Dmitry on 13.09.2015.
 */
public class Computer
{
    private Keyboard keyboard;
    private Monitor monitor;


    public Computer()
    {
        keyboard = new Keyboard();
        monitor = new Monitor();

    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }



    public Monitor getMonitor()
    {
        return monitor;
    }
}
