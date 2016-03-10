package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:\\HOBBY\\Java\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level32\\lesson04\\home01\\file.txt"));
        System.out.println(writer.toString());
    }


    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null)
        {
            InputStreamReader reader = new InputStreamReader(is);
            int lon;
            char[] buf = new char[10];
            while ((lon=reader.read(buf))>0){
                writer.write(buf,0,lon);
            }
        }
        return writer;
    }
}
