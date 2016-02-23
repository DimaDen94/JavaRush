package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Dmitry on 17.02.2016.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
