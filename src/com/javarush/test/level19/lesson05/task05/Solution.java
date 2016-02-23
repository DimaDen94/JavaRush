package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = reader.readLine();
        String fn2 = reader.readLine();
        reader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(fn1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fn2));

        String text= "";
        while (file1.ready()){
            text = text + file1.readLine();
        }
        String [] all= text.split("\\p{Punct}");
        for (String s: all){
            file2.write(s);
        }


        file1.close();
        file2.close();
    }
}
