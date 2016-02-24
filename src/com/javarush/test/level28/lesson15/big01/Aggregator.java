package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;

/**
 * Created by Dmitry on 20.02.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        HHStrategy strategyHH = new HHStrategy();
        MoikrugStrategy strategyMK = new MoikrugStrategy();

        Provider providerHH = new Provider(strategyHH);
        Provider providerMK = new Provider(strategyMK);

        HtmlView view = new HtmlView();
        Model model = new Model(view,providerHH,providerMK);

        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();

    }
}
