package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {



        FileInputStream in = new FileInputStream(args[0]);
        int count = 0;

        boolean isAng;

        while (in.available()>0){
        int a = in.read();
            isAng = (a >= (int)'a'&& a <= (int)'z'||a >= 'A'&& a <='Z');
            if(isAng){
                count++;
            }
        }

        in.close();
        System.out.print(count);



    }
}
