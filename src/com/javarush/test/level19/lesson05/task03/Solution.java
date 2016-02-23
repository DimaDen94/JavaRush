package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn1 = reader.readLine();
        String fn2 = reader.readLine();
        reader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(fn1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fn2));


        String strFile1= "";
        while (file1.ready()){
            strFile1 =strFile1 + file1.readLine();
        }

        String[] splFile1 = strFile1.split(" ");


        for (String s: splFile1){
            if(isNum(s)){
                file2.write(s + " ");
            }
        }

        file1.close();
        file2.close();

    }

    public static boolean isNum(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
