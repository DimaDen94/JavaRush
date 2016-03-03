package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;

/**
 * Created by Dmitry on 03.03.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;
    public class SocketThread extends Thread{

    }
}
