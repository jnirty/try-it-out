package com.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * This example presents usage of ExecutorService for simple use-case:
 * On input you have a list of file links which you want to process consurrently using multiple core processor.
 * On output you expect a result from each file processing, e.g. error code 0..10
 */
public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int poolSize = java.lang.Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors: " + poolSize);

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        List<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
        for (int i = 0; i < 10; i++) {
            callables.add(new Job("sample/url/" + i));
        }
        List<Future<Integer>> results = pool.invokeAll(callables);

        for (Future<Integer> future : results) {
            System.out.println("Result is: " + future.get());
        }

    }
}

class Job implements Callable<Integer> {

    private String urlString;

    public Job(String urlString) {
        this.urlString = urlString;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Doing sth with url " + urlString);
        return new Random().nextInt(10);
    }
}