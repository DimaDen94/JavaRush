package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dmitry on 06.03.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String message;
        while (true)
        {
            try
            {
                message = reader.readLine();
                break;
            }
            catch (IOException e)
            {
                writeMessage("An error occurred while trying to enter text. Try again.");
            }
        }
        return message;

    }

    public static int readInt()
    {
        int readInt;
        while (true)
        {
            try
            {
                readInt = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException e)
            {
                writeMessage("An error occurred while trying to enter the number. Try again.");
            }
        }
        return readInt;
    }
}
