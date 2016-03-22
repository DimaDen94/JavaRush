package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Dmitry on 22.03.2016.
 */
public class AdvertisementStorage
{
    private static AdvertisementStorage instance;
    private AdvertisementStorage(){}
    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }
}
