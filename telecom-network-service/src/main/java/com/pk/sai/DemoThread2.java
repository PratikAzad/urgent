package com.pk.sai;

public class DemoThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i=0;i<100;i++){
            System.out.println("Hii Osho :: "+i);
        }
    }
}
