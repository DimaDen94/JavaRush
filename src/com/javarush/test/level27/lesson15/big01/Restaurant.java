package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;

import java.io.IOException;

/**
 * Created by Dmitry on 22.03.2016.
 */
public class Restaurant
{
    public static void main(String[] args) throws IOException
    {


        Cook cook = new Cook("Cook");


        Tablet tablet5 = new Tablet(5);
        tablet5.addObserver(cook);
        tablet5.createOrder();
    }
}
