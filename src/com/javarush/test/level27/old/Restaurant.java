package com.javarush.test.level27.old;

import com.javarush.test.level27.old.kitchen.Cook;
import com.javarush.test.level27.old.kitchen.Waitor;

/**
 * Created by Dmitry on 19.02.2016.
 */
public class Restaurant {
    public static void main(String[] args) {
        Waitor waitor = new Waitor();

        Cook cook = new Cook("Cook");
        cook.addObserver(waitor);

        Tablet tablet5 = new Tablet(5);
        tablet5.addObserver(cook);
        tablet5.createOrder();

    }
}
