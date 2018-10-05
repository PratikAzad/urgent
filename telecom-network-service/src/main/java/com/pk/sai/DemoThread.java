package com.pk.sai;

public class DemoThread implements Runnable{

    private String name;

    public DemoThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        for (int i=0;i<100;i++){
            System.out.println("Hii "+name+" :: "+i);
        }
    }
}
