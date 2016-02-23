package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitry on 17.02.2016.
 */
public class CommandExecutor
{
    private static Map<Operation, Command> map = new HashMap<>();
    static
    {

        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
        map.put(Operation.LOGIN, new LoginCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        map.get(operation).execute();
    }

    private CommandExecutor()
    {

    }

}