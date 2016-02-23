package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] symbols = new byte[fileInputStream.available()];
        fileInputStream.read(symbols);
        Arrays.sort(symbols);

        Map<Byte,Integer> res = new HashMap<Byte,Integer>();
        for (int i =0 ; i <symbols.length; i++){
            int count= 0;
            byte z = symbols[i];
            for (int q = i+1 ; i <symbols.length-1; i++){
                if (symbols[i] == symbols[q]){
                    count++;
                }
            }
            if(!res.containsKey(z)){
                res.put(z,count);
                System.out.println((char) z + " " + count);
            }
        }

fileInputStream.close();
    }
}
