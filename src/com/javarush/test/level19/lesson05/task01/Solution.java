package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        FileReader file1 = new FileReader(f1);
        FileWriter file2 = new FileWriter(f2);
        int index= 0;
        while (file1.ready()){
            index++;
            int data = file1.read();
            if(index%2==0){
                file2.write(data);
            }
        }
        file1.close();
        file2.close();
        reader.close();

    }
}
