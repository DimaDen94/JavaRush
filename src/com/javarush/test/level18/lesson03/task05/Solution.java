package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream streamReader = new FileInputStream(br.readLine());

        while (streamReader.available()>0) {
            map.put(streamReader.read(),1);
        }

        for (Integer x: map.keySet()){
            System.out.print(x + " ");
        }
    }
}

