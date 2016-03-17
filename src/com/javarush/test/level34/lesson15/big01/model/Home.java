package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Dmitry on 17.03.2016.
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        graphics.drawRoundRect(getX(),getY(),getWidth(),getHeight(),1,1);
    }
}
