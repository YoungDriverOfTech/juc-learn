package com.juc.learn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
        blockingQueue.put(1);
        blockingQueue.put(1);
        blockingQueue.put(1); // 这里会卡出，知道别的线程调用了take方法，腾给出空间

        new Thread(() -> {
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
