package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter{

    @Override
    public String getEncoding()
    {
        return super.getEncoding();
    }

    @Override
    public void write(int c) throws IOException
    {
        super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        super.write(str, off, len);
    }

    @Override
    public void flush() throws IOException
    {
        super.flush();
    }

    @Override
    public void close() throws IOException
    {
        super.close();
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        super.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException
    {
        super.write(str);
    }

    @Override
    public Writer append(CharSequence csq) throws IOException
    {
        return super.append(csq);
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException
    {
        return super.append(csq, start, end);
    }

    @Override
    public Writer append(char c) throws IOException
    {
        return super.append(c);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable
    {
        super.finalize();
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }
}
