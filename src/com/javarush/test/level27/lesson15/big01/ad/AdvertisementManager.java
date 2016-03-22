package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

/**
 * Created by Dmitry on 22.03.2016.
 */
public class AdvertisementManager
{
    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();;
    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }
    public void processVideos(){
        ConsoleHelper.writeMessage("processVideos method calling");
    }
}
