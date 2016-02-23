package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private String surname;
        private int age;
        private String address;
        private int phone;
        private String car;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, String surname)
        {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, int age)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public Human(String name, String surname, int age, String address)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.address = address;
        }

        public Human(String name, String surname, int age, String address, int phone)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.address = address;
            this.phone = phone;
        }

        public Human(String name, String surname, int age, String address, int phone, String car)
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.address = address;
            this.phone = phone;
            this.car = car;
        }

        public Human(String surname, int age)
        {
            this.surname = surname;
            this.age = age;
        }

        public Human(String surname, int age, String address)
        {
            this.surname = surname;
            this.age = age;
            this.address = address;
        }

        public Human(String surname, int age, String address, int phone)
        {
            this.surname = surname;
            this.age = age;
            this.address = address;
            this.phone = phone;
        }

        public Human(String surname, int age, String address, int phone, String car)
        {
            this.surname = surname;
            this.age = age;
            this.address = address;
            this.phone = phone;
            this.car = car;
        }
    }
}
