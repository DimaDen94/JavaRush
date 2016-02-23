package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Dmitry on 16.02.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    private static ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common_en");
    public static void main(String[] args)
    {

        Locale.setDefault(Locale.ENGLISH);

        try
        {
            Operation operation;
            CommandExecutor.execute(Operation.LOGIN);
            do
            {
                ConsoleHelper.writeMessage(res.getString("choose.operation"));
                ConsoleHelper.writeMessage("1: "+ res.getString("operation.INFO"));
                ConsoleHelper.writeMessage("2: "+ res.getString("operation.DEPOSIT"));
                ConsoleHelper.writeMessage("3: "+ res.getString("operation.WITHDRAW"));
                ConsoleHelper.writeMessage("4: "+ res.getString("operation.EXIT"));
                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e) {
            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignored) {
            }
            ConsoleHelper.printExitMessage();
        }
    }
}
