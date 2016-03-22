package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dmitry on 22.03.2016.
 */
public class Order {
    private List<Dish> dishes;
    private Tablet orderedTablet;

    @Override
    public String toString() {
        if (dishes.isEmpty()) return "";


        String chosenDishString = String.format("Your order: %s of %s", dishes, orderedTablet.toString());
        return chosenDishString;
    }
    public Order(Tablet orderedTablet) throws IOException {
        this.orderedTablet = orderedTablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }


}

