package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Dmitry on 03.03.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;


    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("input address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("input server port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("input name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        Message message = new Message(MessageType.TEXT, text);
        try
        {
            connection.send(message);
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("error");
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("error");
            return;
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

            while (clientConnected)
            {
                String message;
                if (!(message = ConsoleHelper.readString()).equals("exit"))
                {
                    if (shouldSentTextFromConsole())
                    {
                        sendTextMessage(message);
                    }
                } else
                {
                    return;
                }
            }
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }


    }


    public class SocketThread extends Thread
    {
        @Override
        public void run()
        {


            try
            {
                Socket socket= new Socket(getServerAddress(),getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }


        protected void clientHandshake() throws IOException,ClassNotFoundException
        {
            while (true){
                Message message = connection.receive();
                if(message.getType()==MessageType.NAME_REQUEST){
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }else if(message.getType()==MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                }else
                    throw new IOException("Unexpected MessageType");
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED)
                {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED)
                {
                    informAboutDeletingNewUser(message.getData());
                } else
                    throw new IOException("Unexpected MessageType");
            }
        }


        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " was added");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(userName + " exit");

        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

    }

}

