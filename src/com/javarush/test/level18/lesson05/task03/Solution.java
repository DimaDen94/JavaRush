package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();
        FileInputStream file1 = new FileInputStream(f1);
        FileOutputStream file2 = new FileOutputStream(f2);
        FileOutputStream file3 = new FileOutputStream(f3);




        while (file1.available() > 0){
            if(file1.available()%2 == 0){
                byte[] fir = new byte[file1.available()/2];
                byte[] sec = new byte[file1.available()/2];
                int count1 = file1.read(fir);
                int count2 = file1.read(sec);
                file2.write(fir,0,count1);
                file3.write(sec,0,count2);
            } else {
                byte[] fir = new byte[file1.available()/2+1];
                byte[] sec = new byte[file1.available()/2];
                int count1 = file1.read(fir);
                int count2 = file1.read(sec);
                file2.write(fir,0,count1);
                file3.write(sec,0,count2);
            }


        }
        reader.close();
        file1.close();
        file2.close();
        file3.close();

    }
}
