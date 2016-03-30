package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready())
        {
            String[] s = reader.readLine().split("\\s");
            Collections.addAll(list, s);
        }
        reader.close();
        String[] words = new String[list.size()];
        words = list.toArray(words);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
        scanner.close();

    }

    public static StringBuilder getLine(String... words) {
        if (words == null) {return new StringBuilder();}
        if (words.length==0) {return new StringBuilder();}


        ArrayList<String> arrayList = new ArrayList<>();
        for (String s: words) {
            arrayList.add(s);
        }
        int neededCounter = arrayList.size();
        StringBuilder resultBuilder;
        while (true)
        {
            int wordCounter = 0;
            ArrayList<String> temp = new ArrayList<>(arrayList);
            Collections.shuffle(temp);
            StringBuilder tempBuilder = new StringBuilder();
            tempBuilder.append(arrayList.get(0));
            temp.remove(arrayList.get(0));
            boolean canAdd = true;

            while (canAdd)
            {
                {
                    ArrayList<String> toDelete = new ArrayList<>();
                    for (String s : temp)
                    {
                        StringBuilder word = new StringBuilder(s);

                        if (tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()))
                        {
                            tempBuilder.append(" " + s);
                            toDelete.add(s);
                            wordCounter++;
                            continue;
                        }

                        if (tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))
                        {
                            tempBuilder.reverse().append(" " + word);
                            tempBuilder.reverse();
                            toDelete.add(s);
                            wordCounter++;
                            continue;
                        }
                    }

                    for (String s : toDelete)
                    {
                        temp.remove(s);
                    }
                    toDelete.clear();

                    for (String s : temp)
                    {
                        StringBuilder word = new StringBuilder(s);
                        if (!tempBuilder.substring(tempBuilder.length() - 1).equals(word.reverse().substring(s.length() - 1).toLowerCase()) &&
                                !tempBuilder.toString().substring(0, 1).toLowerCase().equals(s.substring(s.length() - 1).toLowerCase()))
                        {
                            canAdd = false;
                        }
                    }
                }
                resultBuilder = tempBuilder;
                if (wordCounter==neededCounter-1) {
                    return resultBuilder;
                }
            }
        }
    }
}