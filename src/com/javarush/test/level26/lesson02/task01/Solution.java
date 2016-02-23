package com.javarush.test.level26.lesson02.task01;

import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Comparator<Integer> integerComparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return 0;
            }
        };
        //implement logic here
        return array;
    }
}
