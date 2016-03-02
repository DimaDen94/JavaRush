package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dmitry on 29.02.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException
    {
        ConsoleHelper.writeMessage("input your port");

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

    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Map.Entry<String, Connection> connection : connectionMap.entrySet())
            {
                Connection conn = connection.getValue();
                conn.send(message);

            }
        }
        catch (IOException e)
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

        @Override
        public void run()
        {

            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + " connected");
            String userName = null;
            try(Connection connection = new Connection(socket);)
            {
                ConsoleHelper.writeMessage("connected port: " + connection.getRemoteSocketAddress());
                ConsoleHelper.writeMessage("input your name");
                userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));

                sendListOfUsers(connection,userName);

                serverMainLoop(connection,userName);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("connection error");
            }
            catch (ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("connection error");
            }

            connectionMap.remove(userName);

            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            ConsoleHelper.writeMessage("connection was completed");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message message = connection.receive();

                if (message.getType() == MessageType.USER_NAME && message.getData() != null && !message.getData().isEmpty())
                {

                    if (!connectionMap.containsKey(message.getData()))
                    {
                        connectionMap.put(message.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return message.getData();
                    }
                }
            }

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (String name : connectionMap.keySet()){
                if(!name.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType()==MessageType.TEXT){
                    String messageWithName = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT,messageWithName));
                }else {
                    ConsoleHelper.writeMessage("incorrect data");
                }
            }
        }
    }
}
