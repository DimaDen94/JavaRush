package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put((double) 1,"ghb");
        labels.put((double) 5,"gb");
        labels.put(5.2,"ghl;hb");
        labels.put(5.36,"ghk,bnb");
        labels.put(5.3,"ghk,oobnb");

    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
