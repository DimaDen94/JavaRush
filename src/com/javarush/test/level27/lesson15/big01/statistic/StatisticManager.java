package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;

/**
 * Created by Dmitry on 23.03.2016.
 */
public class StatisticManager
{
    private static StatisticManager instance = new StatisticManager();

    private StatisticManager()
    {
    }

    public StatisticManager getInstance()
    {
        return instance;
    }

    void register(EventDataRow data)
    {
        //TODO
    }
}
