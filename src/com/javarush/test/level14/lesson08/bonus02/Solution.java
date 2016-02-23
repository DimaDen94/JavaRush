package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());
        int test;
        if (first < second)
        {
            for (int i = 1; i < first; i++)
            {
                test = first - i;
                if (first % test == 0 && second % test == 0)
                {
                    System.out.println(test);
                    break;
                }
            }
        } else if (first > second)
        {
            for (int i = 1; i < second; i++)
            {
                test = second - i;
                if (first % test == 0 && second % test == 0)
                {
                    System.out.println(test);
                    break;
                }
            }
        }
    }
}
