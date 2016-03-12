package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by Dmitry on 12.03.2016.
 */
public class UndoMenuListener implements MenuListener
{
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem)
    {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(MenuEvent e)
    {
        if (view.canUndo())
            undoMenuItem.setEnabled(true);
        else
            undoMenuItem.setEnabled(false);


        if (view.canRedo())
            redoMenuItem.setEnabled(true);
        else
            redoMenuItem.setEnabled(false);
    }

    @Override
    public void menuDeselected(MenuEvent e)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e)
    {

    }
}
