package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Person person = null;
        while (reader.ready())
        {
            String[] tmp = reader.readLine().split(" ");
            String name = tmp[0];
            for (int i = 1; i < tmp.length-3; i++) name+=" " + tmp[i];
            Calendar birthday = new GregorianCalendar(Integer.parseInt(tmp[tmp.length-1]),Integer.parseInt(tmp[tmp.length-2])-1,Integer.parseInt(tmp[tmp.length-3]));
            person = new Person(name,birthday.getTime());
            PEOPLE.add(person);
        }
        reader.close();
        System.out.println(PEOPLE.get(1).getName() + " " + PEOPLE.get(1).getBirthday());
    }

}
