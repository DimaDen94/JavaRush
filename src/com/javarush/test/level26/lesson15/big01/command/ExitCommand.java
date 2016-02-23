package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Dmitry on 17.02.2016.
 */
class ExitCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.exit_en");
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        if (ConsoleHelper.readString().equals(res.getString("yes")))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}
