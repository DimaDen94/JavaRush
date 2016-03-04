package com.javarush.test.level30.lesson15.big01.client;

import java.util.Random;

/**
 * Created by Dmitry on 04.03.2016.
 */
public class BotClient extends Client
{
    public static void main(String[] args)
    {
        BotClient bot = new BotClient();
        bot.run();
    }
    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {

        return "date_bot_" + (new Random().nextInt() * 99);
    }

    public class BotSocketThread extends SocketThread{

    }
}
