package com.javarush.test.level36.lesson08.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader reader = new BufferedReader(new FileReader("D:\\HOBBY\\Java\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level36\\lesson08\\task01\\file"));
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String string = "";
        while (true)
        {
            String line = reader.readLine();
            if (line == null)
            {
                break;
            }
            string = string + line;
        }
        char[] chars = string.toLowerCase().replaceAll("[\\W]|_", "").toCharArray();
        TreeSet<Character> tree = new TreeSet<>();
        for (char c : chars)
        {
            tree.add(c);
        }
        Iterator<Character> it = tree.iterator();

        for (int i = 0; i < 5; i++)
        {
            if(it.hasNext()){
                System.out.print(it.next());
            }
        }
    }
}
