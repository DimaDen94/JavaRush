package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by Dmitry on 17.03.2016.
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.ORANGE);
        graphics.drawRect(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void move(int x, int y)
    {
        setX(getX() + x);
        setY(getY() + y);
    }
}
