package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);


        testString.printSomething();
        String result = outputStream.toString();
        //Возвращаем все как было
        System.setOut(consoleStream);
        String[] spl = result.split(" ");
        result = "";
        for (String s: spl){
            result = result+s;
        }

        String firstN = null;
        String secondN = null;
        int f=0;
        int s=0;
        int calculation = 0;
        String sim = "";
        if (result.contains("+")){
            firstN = result.substring(0,result.indexOf("+"));
            secondN = result.substring(result.indexOf("+")+1,result.indexOf("="));
            f = Integer.parseInt(firstN);
            s = Integer.parseInt(secondN);
            calculation = f + s;
            sim = "+";
        }
        if (result.contains("-")){
            firstN = result.substring(0,result.indexOf("-"));
            secondN = result.substring(result.indexOf("-")+1,result.indexOf("="));
            f = Integer.parseInt(firstN);
            s = Integer.parseInt(secondN);
            calculation = f - s;
            sim = "-";
        }
        if (result.contains("*")){
            firstN = result.substring(0,result.indexOf("*"));
            secondN = result.substring(result.indexOf("*")+1,result.indexOf("="));
            f = Integer.parseInt(firstN);
            s = Integer.parseInt(secondN);
            calculation = f * s;
            sim = "*";
        }

        System.out.println(f + " " + sim + " " + s + " = " + calculation );

    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

