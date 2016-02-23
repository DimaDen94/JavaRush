package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution(){}
    Solution(String f){}
    Solution(Integer i){}

    private Solution(Double d){}
    private Solution(Character f){}
    private Solution(Long i){}

    protected Solution(Double d,Double g){}
    protected Solution(String f, String g){}
    protected Solution(Integer i,Integer k){}

    public Solution(String g,Integer t){}
    public Solution(String f,Double g){}
    public Solution(Integer i, Character f){}
}

