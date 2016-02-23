package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String, Double> map = new TreeMap<String, Double>();



        BufferedReader in=new BufferedReader(new FileReader(args[0]));
        String line=in.readLine();

        while (line!=null){
            String [] array=line.split(" ");
            Double cash=Double.parseDouble(array[1]);

            if (!map.containsKey(array[0])) {
                map.put(array[0],Double.parseDouble(array[1])-Double.parseDouble(array[1]));
            }
            //to calculate sum
            for (Map.Entry<String,Double> pair: map.entrySet()){
                if (pair.getKey().contains(array[0])) map.put(array[0],cash+pair.getValue());
            }
            line=in.readLine();
        }
        in.close();
        Map<String, Double> mapMax = new TreeMap<String, Double>();
        double s = 0;
        for (Map.Entry<String,Double> pair: map.entrySet()){
            if(s<pair.getValue()){
                s = pair.getValue();
            }
        }
        for (Map.Entry<String,Double> pair: map.entrySet()){
            if(s==pair.getValue()){
                mapMax.put(pair.getKey(),pair.getValue());
            }
        }
        for (Map.Entry<String,Double> pair: mapMax.entrySet()){
            System.out.println(pair.getKey());
        }
    }

}
