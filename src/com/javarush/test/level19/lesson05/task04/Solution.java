package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
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

        String strFile1= "";
        while (file1.ready()){
            strFile1 =strFile1 + file1.readLine();
        }

        String repl = strFile1.replace(".","!");

        file2.write(repl);





        file1.close();
        file2.close();
    }
}
