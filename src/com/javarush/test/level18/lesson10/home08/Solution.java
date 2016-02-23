package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/
public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        try
        {
            List<String> filesList = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            while (!file.equals("exit"))
            {
                filesList.add(file);
                file = reader.readLine();
            }
            reader.close();
            for (String s : filesList)
            {
                new ReadThread(s).start();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static  class ReadThread extends Thread
    {
        public ReadThread(String fileName)
        {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        private String fileName;

        public  void run()
        {
            try
            {
                FileInputStream inputStream = new FileInputStream(fileName);
                List<Integer> list = new ArrayList<Integer>();


                while (inputStream.available() > 0)
                {
                    list.add(inputStream.read());
                }
                inputStream.close();

                if (list.size()>0)
                {
                    int id=list.get(0);
                    int max=1;
                    for (int i=1; i<257;i++)
                    {
                        int sum=0;
                        for(int k:list)
                            if (k==i) sum++;

                        if (sum>max) {id=i;max=sum;}
                    }


                    resultMap.put(fileName,id);
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}