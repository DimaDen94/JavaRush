package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dmitry on 22.03.2016.
 */
public class Tablet extends Observable
{
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder() throws IOException
    {
        try
        {
            Order order = new Order(this);
            if (!order.isEmpty())
            {
                ConsoleHelper.writeMessage(order.toString());
                AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                manager.processVideos();
                setChanged();
                notifyObservers(order);
            }
        }
        catch(IOException e){
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }

    @Override
    public String toString()
    {
        return "Tablet{" + "number=" + number + '}';
    }
}