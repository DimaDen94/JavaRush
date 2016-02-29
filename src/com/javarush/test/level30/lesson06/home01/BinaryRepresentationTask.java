package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Dmitry on 29.02.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
    private int x;
    public BinaryRepresentationTask(int x)
    {
        this.x = x;
    }


    @Override
    protected String compute()
    {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return result;
    }

}
