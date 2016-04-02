package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Dmitry on 02.04.2016.
 */
public class MyThread extends Thread
{
    private static AtomicInteger currentPriority = new AtomicInteger(0);

    public MyThread() {
        init();
    }

    public MyThread(Runnable target) {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        init();
    }

    public MyThread(String name) {
        super(name);
        init();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        init();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        init();
    }

    private void init() {
        currentPriority.incrementAndGet();
        currentPriority.compareAndSet(11, 1);

        int newPriority = currentPriority.get();
        if (getThreadGroup() != null) {
            if (newPriority > getThreadGroup().getMaxPriority()) {
                newPriority = getThreadGroup().getMaxPriority();
            }
        }
        setPriority(newPriority);
    }
}
