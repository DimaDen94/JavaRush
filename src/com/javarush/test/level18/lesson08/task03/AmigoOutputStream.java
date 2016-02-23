package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream outFile ;
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException
    {
        super(fileName);
        this.outFile = fileOutputStream;
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        outFile.write(b, off, len);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        outFile.write(b);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();    //To change body of overridden methods use File | Settings | File Templates.
    }


    @Override
    public void write(int b) throws IOException
    {
        outFile.write(b);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public void close() throws IOException
    {
        outFile.flush();
        outFile.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        outFile.close();
    }


}

