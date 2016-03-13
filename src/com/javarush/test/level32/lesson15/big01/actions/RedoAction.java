package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Dmitry on 12.03.2016.
 */
public class RedoAction extends AbstractAction
{
    private View view;
    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.redo();
    }
    public RedoAction(View view){
        this.view = view;
    }
}
