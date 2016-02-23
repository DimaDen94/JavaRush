package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);


        testString.printSomething();
        String result = outputStream.toString();
        //Возвращаем все как было
        System.setOut(consoleStream);


        //разворачиваем строку
        StringBuilder stringBuilder = new StringBuilder(result);

        String reverseString = stringBuilder.toString();
        char[] lit = reverseString.toCharArray();
        String res = "";
        for (int i = 0; i < lit.length; i ++){
            if(isNum(lit[i])){
                res = res + lit[i];
            }
        }

        System.out.println(res);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
    public static boolean isNum(char s){
        try {
            Integer.parseInt(String.valueOf(s));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
