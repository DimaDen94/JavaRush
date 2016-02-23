package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file  = reader.readLine();
reader.close();
        FileInputStream in = new FileInputStream(file);
        int count = 0;
        while (in.available()>0){

        if(in.read()==44){
count++;
        }
        }

in.close();
System.out.print(count);



    }
}
