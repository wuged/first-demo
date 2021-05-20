package com.stjh.firstdemo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wuge
 * @Date: 2021-3-25 11:00
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("当前i：" + i);
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println("ok");
        ExecutorService ex = Executors.newFixedThreadPool(20);
    }
}
