package com.juc.learn;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                // 每个工人开始干活
                int second = new Random().nextInt(10);

                try {
                    Thread.sleep(second * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程" + finalI + "活儿干完了");

                // 活干完了，倒计时减一
                latch.countDown();
            }).start();
        }


        latch.await();
        System.out.println("我是老板，所有的工人的活儿都干完了");


    }
}
