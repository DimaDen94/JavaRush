package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));

        ArrayList<String> sixAndMore = new ArrayList<String>();
        String line;
        String[] lines;
        char[] word;
        while (file1.ready()){
            line = file1.readLine();
            lines = line.split(" ");
            for(String thisWord : lines){
                word = thisWord.toCharArray();
                if(word.length>6){
                    sixAndMore.add(thisWord);
                }
            }

        }

        for(int i = 0;  i < sixAndMore.size(); i ++){
            if(i != sixAndMore.size() -1){
                file2.write(sixAndMore.get(i)+",");
            }else  file2.write(sixAndMore.get(i));

        }
        file1.close();
        file2.close();
    }
}
