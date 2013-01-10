package com.executor;

import java.util.ArrayList;
import java.util.Collections;
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

//        // Create a normal, unsynchronized ArrayList
//        List<String> resultList = new ArrayList<String>();
//
//        // Wrap it in a wrapper that adds synchronization to the ArrayList
//        resultList = Collections.synchronizedList(resultList);

        List<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
        for (int i = 0; i < 10; i++) {
            callables.add(new Job("sample/url/" + i));
        }

        callables = Collections.unmodifiableList(callables);

        List<Future<Integer>> results = pool.invokeAll(callables);

        for (Future<Integer> future : results) {
            try {
                System.out.println("Result is: " + future.get());
            } catch (InterruptedException | ExecutionException exc) {
                exc.printStackTrace();
            }
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
        if (urlString.equals("sample/url/1")) {
            throw new Exception("Thrown by purpose to test Future result");
        }
        return new Random().nextInt(10);
    }
}