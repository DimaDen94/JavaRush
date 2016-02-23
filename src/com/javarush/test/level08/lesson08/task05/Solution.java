package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("1","12");
        map.put("2","32");
        map.put("3","12");
        map.put("4","54");
        map.put("5","43");
        map.put("6","52");
        map.put("7","53");
        map.put("8","22");
        map.put("9","44");
        map.put("0","22");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код

        String str1;
        HashMap<String, String> map2 = new HashMap<String, String>(map);
        HashMap<String, String> map3 = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : map3.entrySet()){
            map2.remove(pair.getKey());
            str1 = pair.getValue();
            if(map2.containsValue(str1))
            {
                removeItemFromMapByValue(map,str1);
            }

        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
