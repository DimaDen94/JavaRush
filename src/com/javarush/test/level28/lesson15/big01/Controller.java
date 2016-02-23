package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Model;

/**
 * Created by Dmitry on 20.02.2016.
 */
public class Controller

{
    public Model model;

    public Controller(Model model)
    {
        if(model == null){
            throw new IllegalArgumentException();
        }
        else if (model.providers.length == 0)
        {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }
    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }
}
