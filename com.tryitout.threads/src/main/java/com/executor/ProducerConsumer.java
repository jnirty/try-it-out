package com.executor;

import java.util.*;
import java.util.concurrent.*;

/**
 * This is example of Executor using producer-consumer pattern,
 * consumer1 and consumer2 do not need to wait for all jobs to be finished
 * before starting to process results.
 */
public class ProducerConsumer {
    private static final int NUM_TO_PROCESS = 10;

    public static void main(String[] args) throws InterruptedException {
        int poolSize = java.lang.Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors: " + poolSize);

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(NUM_TO_PROCESS);

        List<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
        for (int i = 0; i < NUM_TO_PROCESS; i++) {
            callables.add(new Job1(q, "sample/url/" + i));
        }

        callables = Collections.unmodifiableList(callables);

        Producer p = new Producer(pool, callables);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class Producer implements Runnable {
    private final ExecutorService executorService;
    private final List<Callable<Integer>> callables;

    Producer(ExecutorService executorService, List<Callable<Integer>> callables) {
        this.executorService = executorService;
        this.callables = callables;
    }

    public void run() {
        try {
            List<Future<Integer>> results = executorService.invokeAll(callables);

            // print any execution exceptions
            for(Future<Integer> future : results){
                   try {
                       future.get();
                   } catch (ExecutionException e) {
                       e.printStackTrace();
                   }

            }
        } catch ( InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    void consume(Integer result) {
        System.out.println("CONSUMER [" + Thread.currentThread().getName() + "] process result: " + result);
    }
}


class Job1 implements Callable<Integer> {

    private String urlString;
    private Collection result;

    public Job1(Collection q, String urlString) {
        this.urlString = urlString;
        this.result = q;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Doing sth with url " + urlString);
        if (urlString.equals("sample/url/1")) {
            throw new Exception("Thrown by purpose to test Future result");
        }
        String[] tokens = urlString.split("/");
        int code = Integer.parseInt(tokens[tokens.length - 1]);
        System.out.println(code);
        result.add(code);
        return code;
    }
}


