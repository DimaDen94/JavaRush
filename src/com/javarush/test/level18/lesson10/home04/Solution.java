package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);



        byte[] first= new byte[fileInputStream1.available()];
        byte[] second= new byte[fileInputStream1.available()];



            fileInputStream1.read(first);
            fileInputStream2.read(second);

        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
        fileOutputStream1.write(second);
        fileOutputStream1.close();

        FileOutputStream fileOutputStream11 = new FileOutputStream(file1, true);
        fileOutputStream11.write(first);
        fileOutputStream11.close();

        reader.close();
        fileInputStream1.close();
        fileInputStream2.close();

    }
}
