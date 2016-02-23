package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> q= new HashMap<>();
        Cat cat1 = new Cat("CAT1");
        Cat cat2 = new Cat("CAT2");
        Cat cat3 = new Cat("CAT3");
        Cat cat4 = new Cat("CAT4");
        Cat cat5 = new Cat("CAT5");
        Cat cat6 = new Cat("CAT6");
        Cat cat7 = new Cat("CAT7");
        Cat cat8 = new Cat("CAT8");
        Cat cat9 = new Cat("CAT9");
        Cat cat10 = new Cat("CAT10");
        q.put("cat1",cat1);
        q.put("cat2",cat2);
        q.put("cat3",cat3);
        q.put("cat4",cat4);
        q.put("cat5",cat5);
        q.put("cat6",cat6);
        q.put("cat7",cat7);
        q.put("cat8",cat8);
        q.put("cat9",cat9);
        q.put("cat10",cat10);
        return q;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //Напишите тут ваш код
        Set<Cat> cats = new HashSet<Cat>();
        for (Map.Entry<String,Cat> pair: map.entrySet() ) {
            Cat a = pair.getValue();
            cats.add(a);
        }
        return cats;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
