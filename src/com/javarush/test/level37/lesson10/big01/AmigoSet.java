package com.javarush.test.level37.lesson10.big01;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Dmitry on 28.03.2016.
 */
public class AmigoSet<E> extends AbstractSet implements Cloneable, Serializable, Set
{
    @Override
    public Iterator iterator()
    {
        return null;
    }

    @Override
    public int size()
    {
        return 0;
    }
}
