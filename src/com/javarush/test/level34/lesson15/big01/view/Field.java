package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import javax.swing.*;
import java.awt.*;

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

    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }
}
