package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmitry on 15.03.2016.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> longs = new HashSet<>();
        for (String str : strings)
            longs.add(shortener.getId(str));
        return longs;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> longs = new HashSet<>();
        for (Long l : keys)
            longs.add(shortener.getString(l));
        return longs;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> testSetStrings = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++)
        {
            testSetStrings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Set<Long> idsSet;

        Date startTime1 = new Date();
        idsSet = getIds(shortener, testSetStrings);
        Date finishTime1 = new Date();

        long msDelay1 = finishTime1.getTime() - startTime1.getTime();
        Helper.printMessage(Long.toString(msDelay1));


        Set<String> stringSet;
        Date startTime2 = new Date();
        stringSet = getStrings(shortener, idsSet);
        Date finishTime2 = new Date();

        long msDelay2 = finishTime2.getTime() - startTime2.getTime();
        Helper.printMessage(Long.toString(msDelay2));

        if (stringSet.equals(testSetStrings))
        {
            Helper.printMessage("Тест пройден.");
        } else
        {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args)
    {


        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
    }
}
