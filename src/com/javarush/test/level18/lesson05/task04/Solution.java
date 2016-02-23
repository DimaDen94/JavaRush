package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(f1);
        FileOutputStream file2 = new FileOutputStream(f2);
        byte[] b = new byte[file1.available()];
        while (file1.available() > 0){
            file1.read(b);

        }
        byte[] by = new byte[b.length];
        for (int i = 0; i<b.length; i++) {
            by[i] = b[b.length-1-i];
        }
        file2.write(by);
        reader.close();
        file1.close();
        file2.close();

    }
}
