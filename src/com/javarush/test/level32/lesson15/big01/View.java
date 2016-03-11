package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
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
        FrameListener  listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }
    public void exit(){
        controller.exit();
    }
    public void initMenuBar(){

    }
    public void initEditor(){

        htmlTextPane.setContentType("text/html");

        tabbedPane.add("HTML", new JScrollPane(htmlTextPane));

        tabbedPane.add("Текст", new JScrollPane(plainTextPane));

        tabbedPane.setPreferredSize(new Dimension(800,600));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();

    }

    public void selectedTabChanged(){}

}
