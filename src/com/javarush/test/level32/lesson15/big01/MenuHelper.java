package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 11.03.2016.
 */
public class MenuHelper
{
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener)
    {
        JMenuItem item = new JMenuItem(text);
        item.addActionListener(actionListener);
        parent.add(item);
        return item;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action)
    {
        JMenuItem item = new JMenuItem(action);
        item.setText(text);
        parent.add(item);
        return item;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action)
    {
        JMenuItem item = new JMenuItem(action);
        parent.add(item);
        return item;

    }


    public static void initHelpMenu(View view, JMenuBar menuBar)
    {
    }

    public static void initFontMenu(View view, JMenuBar menuBar)
    {
    }

    public static void initColorMenu(View view, JMenuBar menuBar)
    {
    }

    public static void initAlignMenu(View view, JMenuBar menuBar)
    {
    }

    public static void initStyleMenu(View view, JMenuBar menuBar)
    {
    }

    public static void initEditMenu(View view, JMenuBar menuBar)
    {
    }

    public static void initFileMenu(View view, JMenuBar menuBar)
    {
    }
}
