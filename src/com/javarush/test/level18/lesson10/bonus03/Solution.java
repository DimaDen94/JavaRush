package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //String par = "-c product Name 120 20";
        //String par = "-d 198479";
        //String par = "-u 19846 Шорты пляжные 159.00 12";
        //String[] arg = par.split(" ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();


        if (args[0].equals("-u"))
        {
            String productName = "";
            for (int i = 2; i < args.length - 2; i++)
                productName = productName + args[i] + " ";

            String trueProductName = setLength(productName, 30);

            String truePrice = setLength(args[args.length - 2], 8);
            String trueQuantity = setLength(args[args.length - 1], 4);

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            String id = args[1];

            List<String> list = new ArrayList<>();
            while ((line = reader.readLine()) != null)
            {
                String idLine = null;
                if (!line.isEmpty())
                {
                    idLine = line.substring(0, 8).replaceAll(" ", "");
                }
                if (id.equals(idLine))
                {
                    list.add(setLength(id, 8) + trueProductName + truePrice + trueQuantity);
                }else {
                    list.add(line);
                }
            }


            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (String s : list)
            {
                printWriter.println(s);
            }
            printWriter.close();

        } else if (args[0].equals("-d"))
        {
            String id = args[1];
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            List<String> list = new ArrayList<>();
            while ((line = reader.readLine()) != null)
            {
                String idLine = null;
                if (!line.isEmpty())
                {
                    idLine = line.substring(0, 8).replaceAll(" ", "");
                }
                if (!id.equals(idLine))
                {
                    list.add(line);
                }
            }

            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));


            for (String s : list)
            {
                printWriter.println(s);
            }
            printWriter.close();

        }

    }


    public static String getMaxId(String fileName) throws IOException
    {
        ArrayList<Long> allIds = new ArrayList<Long>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        Long currentId;
        while ((line = bufferedReader.readLine()) != null)
        {
            line = line.substring(0, 8).replaceAll("\\s", "");
            currentId = Long.parseLong(line);
            allIds.add(currentId);
        }
        bufferedReader.close();
        Long maxId = Collections.max(allIds);
        Long MyId = maxId + 1;
        return MyId.toString();
    }


    public static String setLength(String previousName, int count)
    {
        String trueName;
        if (previousName.length() > count)
            trueName = previousName.substring(0, count);
        else
        {
            String s = "";
            for (int i = 0; i < (count - previousName.length()); i++)
                s = s + " ";
            trueName = previousName + s;
        }
        return trueName;
    }
}

