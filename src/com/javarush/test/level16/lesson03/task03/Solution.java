package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread ob1 = new SpecialThread();
        SpecialThread ob2 = new SpecialThread();
        SpecialThread ob3 = new SpecialThread();
        SpecialThread ob4 = new SpecialThread();
        SpecialThread ob5 = new SpecialThread();


        list.add(new Thread(ob1));
        list.add(new Thread(ob2));
        list.add(new Thread(ob3));
        list.add(new Thread(ob4));
        list.add(new Thread(ob5));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
