package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Set<File> fileset = new TreeSet<>();
        while (!(name = reader.readLine()).equals("end")) {
            File file = new File(name);
            fileset.add(file);
        }
        reader.close();
        Iterator<File> itr = fileset.iterator();
        String folder = itr.next().getAbsolutePath();
        folder = folder.substring(0, folder.length() - 6);
        FileOutputStream resultFile = new FileOutputStream(folder, true);
        for (File file : fileset) {
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[in.available()];
            while (in.available() > 0) {
                in.read(buffer);
                resultFile.write(buffer);
            }
            in.close();
        }
        resultFile.close();
    }
}
