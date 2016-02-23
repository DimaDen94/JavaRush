package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    FileOutputStream out;
    AdapterFileOutputStream(FileOutputStream out){
        this.out = out;
    }
    @Override
    public void flush() throws IOException
    {
        out.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        out.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
        out.close();
    }
}

