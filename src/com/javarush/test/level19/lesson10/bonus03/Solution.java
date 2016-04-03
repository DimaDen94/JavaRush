package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> sList = new ArrayList<>();
        while (file.ready()) {
            stringBuilder = stringBuilder.append(file.readLine());
        }
        String t = args[0];
        String s = stringBuilder.toString().replaceAll("\r\n", "");
        ArrayList<Pair> list = new ArrayList<>();
        String open = "<".concat(t);
        String closing = "</".concat(t);
        int len = t.length();
        int index1 = 0;

        while ((index1 != -1) && (index1 < s.length())) {
            index1 = s.indexOf(open, index1);
            int index2 = s.indexOf(closing, index1 + len);
            int k = index1 + len;
            if (index2 != -1) {
                while (s.substring(k, index2).contains(open)) {
                    k = index2 + len;
                    index2 = s.indexOf(closing, k);
                }
            }
            if (index1 != -1 && index2 != -1) {
                list.add(new Pair(index1, index2));
                index1 += len;
            }
        }

        for (Pair pair : list) {
            String str = s.substring(pair.getA(), pair.getB() + len + 3);
            sList.add(str);
        }


        for (String s1 : sList) {
            System.out.println(s1);
        }
    }

    public static class Pair {
        private int a;
        private int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}