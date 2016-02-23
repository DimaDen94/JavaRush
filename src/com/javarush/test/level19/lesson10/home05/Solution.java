package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader fFile = new BufferedReader(new FileReader(args[0]));
        BufferedWriter sFile = new BufferedWriter(new FileWriter(args[1]));
        String line = null;
        String[] lineSpl = null;



        while (fFile.ready()){
            line = fFile.readLine();
            lineSpl = line.split(" ");
            for (String word : lineSpl){
                if (word.matches(".+[0-9].+")){
                    sFile.write(word + " ");
                }
            }
        }
        fFile.close();
        sFile.close();


    }
}
