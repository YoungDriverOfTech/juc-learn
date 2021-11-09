package com.juc.learn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 一个线程池，里面有10个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // 给线程池提交一个任务（runnable实现），但是future会立即返回，
        Future<?> future = threadPool.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我结束工作了");
            // 如果在这里抛出异常，那么future.get的时候，就会把这个异常拿到
        });

        System.out.println("我把工作提交了");
        // future.get() 会等待线程池里面的某个线程把任务执行完，才能拿到结果，在那之前，get方法会阻塞
        System.out.println(future.get());
        System.out.println("工作做完");
    }
}
