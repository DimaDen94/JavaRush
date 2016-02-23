package com.javarush.test.level13.lesson04.task03;

/* Интерфейс Animal
1. Унаследовать Fox от интерфейса Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод - getName.
3. Создавать дополнительные классы и удалять методы нельзя!
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    public interface Animal
    {
        String  getName();
    }

    public static class Fox implements Animal
    {
        public String getName()
        {
            return "Fox";
        }


    }
}
