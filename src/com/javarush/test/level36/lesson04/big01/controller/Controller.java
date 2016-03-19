package com.javarush.test.level36.lesson04.big01.controller;

import com.javarush.test.level36.lesson04.big01.model.Model;

/**
 * Created by Dmitry on 20.03.2016.
 */
public class Controller
{
    private Model model;

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void onShowAllUsers()
    {
        model.loadUsers();
    }
}
