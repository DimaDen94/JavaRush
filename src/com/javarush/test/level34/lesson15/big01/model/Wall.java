package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Dmitry on 17.03.2016.
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawRect(getX(),getY(),getWidth(),getHeight());
    }
}
