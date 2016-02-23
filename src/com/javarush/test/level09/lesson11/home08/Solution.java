package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> i = new ArrayList<>();
        //напишите тут ваш код
        int[] f1 = {1,2,3,4,5};
        int[] f2 = {1,2};
        int[] f3 = {1,2,3,4};
        int[] f4 = {1,2,3,4,5,6,7};
        int[] f6 = {};
        i.add(f1);
        i.add(f2);
        i.add(f3);
        i.add(f4);

        i.add(f6);
        return i;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
