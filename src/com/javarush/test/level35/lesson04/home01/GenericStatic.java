package com.javarush.test.level35.lesson04.home01;

public class GenericStatic {



    public static <T>Object someStaticMethod(T genericObject) {
        System.out.println(genericObject);

        return genericObject;
    }
}
