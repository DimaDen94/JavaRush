package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

import java.io.IOException;

/**
 * Created by Dmitry on 20.02.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HHStrategy strategy = new HHStrategy();
        Provider provider = new Provider(strategy);

        HtmlView view = new HtmlView();
        Model model = new Model(view,provider);

        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();

    }
}
