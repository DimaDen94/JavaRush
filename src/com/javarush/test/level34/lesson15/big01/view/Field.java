package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Created by Dmitry on 17.03.2016.
 */
public class Field extends JPanel
{
    private View view;
    private EventListener eventListener;
    public Field( View view)
    {
        this.view = view;
    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        Set<GameObject> gameObjectSet = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjectSet) {
            gameObject.draw(g);
        }
    }


    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
}
