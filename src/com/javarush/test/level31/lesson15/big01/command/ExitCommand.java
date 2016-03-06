package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class ExitCommand implements Command
{
    @Override
    public void execute() throws Exception
    {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
