package com.javarush.test.level27.old.kitchen;

import com.javarush.test.level27.old.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dmitry on 19.02.2016.
 */
public class Waitor implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        ConsoleHelper.writeMessage(arg + " was cooked by " + ((Cook) o).name);
    }
}
