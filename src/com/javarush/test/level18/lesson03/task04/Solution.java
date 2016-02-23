package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Byte,Integer> letters = new HashMap<Byte, Integer>();

        String file = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(new File(file));



        byte[] buffer = new byte[inputStream.available()];

        while (inputStream.available() > 0){
            inputStream.read(buffer);

        }

        for(byte c:buffer) {
            int count = 0;
            for(byte c1:buffer)
            {
                if(c == c1)
                    count++;
            }
            letters.put(c, count);
        }


        int Maxbyte = buffer[0];
        for(Map.Entry<Byte, Integer> pair :letters.entrySet())
        {
            if (pair.getValue() < Maxbyte)
                Maxbyte = pair.getValue();
        }
        for(Map.Entry<Byte, Integer> pair :letters.entrySet())
        {
            if (pair.getValue().equals(Maxbyte))
                System.out.print(pair.getKey()+ " ");
        }
        inputStream.close();


    }

}
