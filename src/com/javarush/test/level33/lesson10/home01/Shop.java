package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 15.03.2016.
 */
@XmlType(name = "shop")
@XmlRootElement
class Shop
{
    @XmlElementWrapper(name="goods", nillable = true)
    public List<String> names;
    public int count;
    public double profit;
    public List<String> secretData;

    public Shop()
    {
        names = new ArrayList<>();
        secretData = new ArrayList<>();
    }
}

