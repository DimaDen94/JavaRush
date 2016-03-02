package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Dmitry on 29.02.2016.
 */
public class Server
{
    public static void main(String[] args) throws IOException
    {
        int port = ConsoleHelper.readInt();
        try
        {
            try (ServerSocket serverSocket = new ServerSocket(port);)
            {
                ConsoleHelper.writeMessage("server was started");
                while (true)
                {
                    Socket socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();

                }
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage("error");
        }


    }

    private static class Handler extends Thread
    {

        private Socket socket;
        Handler(Socket socket)
        {
            this.socket = socket;
        }
    }
}
