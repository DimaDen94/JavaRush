package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dmitry on 19.02.2016.
 */
public class Tablet extends Observable{
    private final int number;
    private Order order;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private AdvertisementManager manager;

    public Tablet(int number) {
        this.number = number;
    }
    public void createOrder() {
        try {
            order = new Order(this);

            ConsoleHelper.writeMessage(order.toString());
            if(!order.isEmpty()){
                manager = new AdvertisementManager(order.getTotalCookingTime()*60);
                manager.processVideos();
                super.setChanged();
                notifyObservers(order);
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE,"Console is unavailable.");
        }
        catch (NoVideoAvailableException e)
        {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }

    }
    @Override
    public String toString() {
        return "Tablet{number="+number+"}";
    }
}