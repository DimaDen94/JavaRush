package com.javarush.test.level25.lesson07.home02;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface CancellableTask<T> extends Callable<T> {
    void cancel() throws IOException;

    RunnableFuture<T> newTask();
}