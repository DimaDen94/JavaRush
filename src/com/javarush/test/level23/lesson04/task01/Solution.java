package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution s1 = new Solution();
        Solution s2 = new Solution();
        Solution[] s = new Solution[2];

        s1.innerClasses[0] = s1.new InnerClass();
        s1.innerClasses[1] = s1.new InnerClass();
        s2.innerClasses[0] = s2.new InnerClass();
        s2.innerClasses[1] = s2.new InnerClass();
        s[0] = s1;
        s[1] = s2;


        return s;
    }
}
