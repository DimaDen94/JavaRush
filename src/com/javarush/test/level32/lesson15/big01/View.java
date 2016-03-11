package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 09.03.2016.
 */
public class View extends JFrame implements ActionListener
{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public void init(){
        initGui();
        FrameListener  listener = new FrameListener(View.this);
        View.this.addWindowListener(listener);
        View.this.setVisible(true);
    }
    public void exit(){
        controller.exit();
    }
    public void initMenuBar(){

    }
    public void initEditor(){
        initGui();
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();

    }

    public void selectedTabChanged(){}

}
