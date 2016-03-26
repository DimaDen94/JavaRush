package com.javarush.test.level37.lesson04.big01;

import com.javarush.test.level37.lesson04.big01.male.MaleFactory;

/**
 * Created by Dmitry on 26.03.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {
        MaleFactory factory = new MaleFactory();
        Human human1 = factory.getPerson(99);
        Human human2 = factory.getPerson(4);
        Human human3 = factory.getPerson(15);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
    }
}
