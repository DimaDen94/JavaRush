package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Dmitry on 22.03.2016.
 */
public enum Dish
{
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        for (Dish dish : Dish.values()) {
            sb.append(dish);
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        return sb.toString();
    }
}
