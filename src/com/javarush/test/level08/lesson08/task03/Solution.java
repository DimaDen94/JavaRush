package com.javarush.test.level08.lesson08.task03;

import java.util.*;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map,"Filip"));
        System.out.println(getCountTheSameLastName(map,"Furion"));
    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String,String> fio = new HashMap<>();
        fio.put("Donkin","Filip");
        fio.put("Drink","Fnig");
        fio.put("Furion","Gim");
        fio.put("Gonim","Filip");
        fio.put("Drink","Gim");
        fio.put("Migo","Gim");
        fio.put("Drink","Gim");
        fio.put("Drink","Gim");
        fio.put("Drink","Gim");
        fio.put("Drink","Gim");
        return fio;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int c = 0;
        for (Map.Entry<String,String> pair : map.entrySet()){
            String value = pair.getValue();
            if(name.equals(value)){
                c++;
            }

        }
        return c;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int c = 0;
        for (Map.Entry<String,String> pair : map.entrySet()){
            String key = pair.getKey();
            if(familiya.equals(key)){
                c++;
            }

        }
        return c;
       /* Iterator<Map.Entry<String, Date>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()){
            int m = iterable.next().getValue().getMonth() + 1;
            if(m >= 6 && m <=8){
                iterable.remove();
            }

        }*/
    }
}
