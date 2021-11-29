package com.juc.learn;

public class App {
    private String name;
    private Object object = new Object();
    /***
     * 运算
     */
    public int add() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 100;
        return c;
    }
    /**
     * 程序入口
     */
    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        int result = app.add();
        System.out.println(result);

    }
}
