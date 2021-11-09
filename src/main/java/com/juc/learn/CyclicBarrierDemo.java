package com.juc.learn;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                // 每个工人开始干活
                int second = new Random().nextInt(10);

                try {
                    Thread.sleep(second * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程" + finalI + "活儿干完了");

                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("等其他人到了，我们才能继续");

            }).start();
        }
    }
}
