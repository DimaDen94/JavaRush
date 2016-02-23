package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();
        String afterQ = url.substring(url.indexOf("?")+1);
        String[] mas = afterQ.split("(\\&+)|(\\?+)");

        ArrayList<String> teg = new ArrayList<String>();
        Pattern pat = Pattern.compile("^obj=.*");
        for (String s : mas){
            if(!(s.equals(""))){
                Matcher matcher = pat.matcher(s);
                if (matcher.find()){teg.add(s.substring(s.indexOf("=")+1));}
                if (s.contains("=")){System.out.print(s.substring(0, (s.indexOf("="))) + " ");}
                else System.out.print(s + " ");
            }
        }
        Pattern toOb1 = Pattern.compile("[0-9.]");
        Pattern toOb2 = Pattern.compile("[a-zA-Z]");
        //add your code here
        System.out.println();

        for (String s : teg){
            Matcher matcher1 = toOb1.matcher(s);
            Matcher matcher2 = toOb2.matcher(s);
            if (matcher1.find()){alert(Double.parseDouble(s));}
            else if (matcher2.find()){alert(s);}
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
