package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Dmitry on 30.11.2015.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public double getAmount()
    {

        return super.getAmount();
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
