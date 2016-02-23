package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution { public static void main(String[] args) throws IOException {
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

    for (Map.Entry<String,Double> pair: map.entrySet()){
        System.out.println(pair.getKey()+" " +pair.getValue());
    }
}
}