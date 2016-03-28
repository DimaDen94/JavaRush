package com.javarush.test.level37.lesson10.big01;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Dmitry on 28.03.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E>
{
    private final static Object PRESENT = new Object();
    private  HashMap<E, Object> map;

    public AmigoSet(Collection<? extends E> collection)
    {
        map = new HashMap<>((int) Math.max(16, collection.size() / .75f));
        this.addAll(collection);
    }

    public AmigoSet()
    {
        map = new HashMap<>();

    }

    @Override
    public Iterator<E> iterator()
    {
        return null;
    }


    @Override
    public boolean add(E e) {
        return null == map.put(e,PRESENT);
    }



    @Override
    public int size()
    {
        return map.keySet().size();
    }
}
