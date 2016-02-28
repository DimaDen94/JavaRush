package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {

        int i = 0;
        if (s.startsWith("0x")){
            i = Integer.parseInt(s.replaceFirst("0x",""),16);
        }else if (s.startsWith("0b")){
            i = Integer.parseInt(s.replaceFirst("0b",""),2);
        }else if (s.startsWith("0")){
            i = Integer.parseInt(s.replaceFirst("0",""),8);
        }else {
            i = Integer.parseInt(s,10);
        }
        return "" + i;
    }
}
