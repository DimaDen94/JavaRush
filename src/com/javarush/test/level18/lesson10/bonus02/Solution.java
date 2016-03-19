package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //String par = "-c product Name 120 20";
        //String[] arg = par.split(" ");

        String productName = "";
        String price;
        String quantity;

        String allData = null;


        //File file = new File("D:\\HOBBY\\Java\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level18\\lesson10\\bonus02\\file.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(bufferedReader.readLine());
        bufferedReader.close();


        if (args[0].substring(0, 2).equals("-c"))
        {
            //String[] split = par.split(" ");
            int arrLength = args.length;
            for (int i = 1; i < arrLength - 2; i++)
            {
                productName = productName + args[i] + " ";
            }

            price = args[arrLength - 2];
            quantity = args[arrLength - 1];

            productName = doLength(productName, 30);
            price = doLength(price, 8);
            quantity = doLength(quantity, 4);
            allData = productName + price + quantity;

            System.out.println(allData);
        }
        String id = doLength(getId(file), 8);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

        writer.write("\n" + id + allData);
        writer.close();

    }

    private static String doLength(String str, int len)
    {
        if (str.length() < len)
        {
            int l = str.length();
            int dif = len - l;
            for (int i = 0; i < dif; i++)
            {
                str = str + " ";
            }
            return str;
        } else if (str.length() > len)
        {
            return str.substring(0, len);
        }
        return str;
    }

    public static String getId(File file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        int maxId = 0;
        while ((line = reader.readLine()) != null)
        {
            int id = Integer.parseInt(line.substring(0, 8).replaceAll(" ", ""));
            System.out.println(id);
            if (id >= maxId)
                maxId = id + 1;
        }
        reader.close();
        return "" + maxId;
    }

}
