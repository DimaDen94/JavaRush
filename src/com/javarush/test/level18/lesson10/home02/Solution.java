package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        int charCount;
        int spaceCount = 0;

        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[fileInputStream.available()];

        if (fileInputStream.available()>0)
            fileInputStream.read(buffer);

        charCount = buffer.length;

        for (byte aBuffer : buffer)
        {
            if (aBuffer == 32)
                spaceCount++;
        }

        double x = ((double)spaceCount/(double)charCount)*100;
        System.out.println(String.format("%.2f", x));
        fileInputStream.close();

    }
}