package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null)
            throw new TooShortStringException();
        int firstSpace = string.indexOf(" ");
        if(firstSpace==-1){
            throw new TooShortStringException();
        }
        int secondSpace = string.indexOf(" ",firstSpace+1);
        if(secondSpace==-1){
            throw new TooShortStringException();
        }
        int threeSpace = string.indexOf(" ", secondSpace +1);
        if(threeSpace==-1){
            throw new TooShortStringException();
        }
        int fourSpace = string.indexOf(" ", threeSpace +1);
        if(fourSpace==-1){
            throw new TooShortStringException();
        }
        int fiveSpace =  string.indexOf(" ",fourSpace+1);
        if(fiveSpace==-1){
            throw new TooShortStringException();
        }

        String test1 = string.substring(firstSpace+1,fiveSpace);
        return test1;
    }

    public static class TooShortStringException extends Throwable
    {
    }
}
