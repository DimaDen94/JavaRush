package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmitry on 23.03.2016.
 */
public class StatisticManager
{
    private static StatisticManager instance = new StatisticManager();
    private static StatisticStorage statisticStorage = StatisticManager.getInstance().new StatisticStorage();
    private StatisticManager()
    {
    }

    public static StatisticManager getInstance()
    {
        return instance;
    }

    void register(EventDataRow data)
    {
        //TODO
    }

    private class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> eventTypeMap;
        private StatisticStorage()
        {
            this.eventTypeMap = new HashMap<>();
            for (EventType value : EventType.values())
            {
                eventTypeMap.put(value, new ArrayList<EventDataRow>());
            }
        }

    }
}
