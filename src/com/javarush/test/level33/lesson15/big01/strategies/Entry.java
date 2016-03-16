package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Dmitry on 16.03.2016.
 */
public class Entry implements Serializable
{
    final int hash;
    final Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next)
    {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public int hashCode()
    {
        return hash ^ Objects.hashCode(value);
    }

    @Override
    public String toString()
    {
        return key + "=" + value;
    }
}
