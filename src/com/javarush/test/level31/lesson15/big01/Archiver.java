package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.IOException;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class Archiver
{
    public static void main(String[] args) throws Exception
    {
        Operation operation = null;
        while (true)
        {
            try
            {
                operation = askOperation();
                CommandExecutor.execute(operation);
            }
            catch (WrongZipFileException e)
            {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            }
            catch (Exception e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");

            }
            if (operation==Operation.EXIT)
                break;
        }

    }

    public static Operation askOperation() throws IOException
    {

        for (Operation operation : Operation.values())
        {
            ConsoleHelper.writeMessage(operation.ordinal() + " " + operation.toString());
        }
        return Operation.values()[ConsoleHelper.readInt()];
    }
}
