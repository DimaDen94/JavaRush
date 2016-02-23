package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Denezhko", new Date("MAY 19 1994"));
        map.put("Marahovskaya", new Date("JANUARY 20 1995"));
        map.put("Cibulko", new Date("JONE 15 1990"));
        map.put("Finik", new Date("AUGUST 11 1991"));
        map.put("Morgan", new Date("JUNE 1 1996"));
        map.put("Miciangelo", new Date("APRIL 19 1975"));
        map.put("Cart", new Date("OCTOBER 1 1977"));
        map.put("Timin", new Date("JUNE 1 1980"));
        map.put("Catton", new Date("JUNE 1 1980"));
        return map;
        //напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {


        for (Map.Entry<String,Date> pair : map.entrySet()){
            int q = pair.getValue().getMonth()+1;
            if(q >= 6 && q <=8){
                map.remove(pair.getKey());
            }
        }
        //напишите тут ваш код

    }
}
