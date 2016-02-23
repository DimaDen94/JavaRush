package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream inFile2 = new FileInputStream(file2);
        FileInputStream inFile3 = new FileInputStream(file3);

        FileOutputStream outFile1 = new FileOutputStream(file1);


        while (inFile2.available()>0){
            int data = inFile2.read();
            outFile1.write(data);
        }
        while (inFile3.available()>0){
            int data = inFile3.read();
            outFile1.write(data);
        }
        reader.close();
        inFile2.close();
        inFile3.close();
        outFile1.close();
    }
}
