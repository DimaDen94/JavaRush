package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.AbstractFactory;
import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by Dmitry on 26.03.2016.
 */
public class MaleFactory implements AbstractFactory
{
    public Human getPerson(int age)
    {
        if(age<=KidBoy.MAX_AGE){
            return new KidBoy();
        }else if(age<=TeenBoy.MAX_AGE){
            return new TeenBoy();
        }else
            return new Man();
    }
}
