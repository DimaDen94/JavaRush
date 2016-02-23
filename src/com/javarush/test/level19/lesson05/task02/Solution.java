package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(fn));
       int match = 0;
    String line = "";
    while (file.ready())
    {
        int a = file.read();
        if (a == 13 && a == 11)
            line += '.';
        else line+=(char)a;
    }
    line = line.replaceAll("\\,|\\.", "");
        line = line.replace(System.getProperty("line.separator"), " ");
        String[] lineArray = line.split(" ");
  for (int i = 0; i < lineArray.length; i++)
    {
        if (lineArray[i].matches("world"))
            match++;
    }
    System.out.println(match);

        file.close();

    }
}
