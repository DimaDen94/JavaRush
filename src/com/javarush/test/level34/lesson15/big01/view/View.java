package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dmitry on 17.03.2016.
 */
public class View extends JFrame
{
    private Controller controller;

    public View(Controller controller) throws HeadlessException
    {
        this.controller = controller;
    }
}
