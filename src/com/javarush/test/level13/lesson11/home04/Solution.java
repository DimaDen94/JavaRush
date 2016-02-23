package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //Открываем поток, считывающий имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //Открываем исходящий поток в указанное имя файла
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        while (true)
        {
            //Считываем строку
            String s = reader.readLine();

            //если строка содержит exit, то записываем эту строку в файл и закрываем цикл
            if (s.equals("exit"))
            {
                //записываем в файл преобразованные в байты значения
                fileOutputStream.write(s.getBytes());
                break;
            }

            //иначе (не содержит exit) - записываем в файл преобразованные в байты значения
            //обязательно присоединяем к строке пробел и перевод строки
            else
            {
                fileOutputStream.write((s+"\r\n").getBytes());
            }
        }


        //закрываем потоки
        fileOutputStream.close();
        reader.close();
    }
}
