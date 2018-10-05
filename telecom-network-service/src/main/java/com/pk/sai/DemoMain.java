package com.pk.sai;

public class DemoMain {
    public static void main(String[] args) {
        DemoThread thread1=new DemoThread("Sai");
        DemoThread thread2=new DemoThread("Osho");

       System.out.println(Thread.currentThread().getName());
        Thread thread01=new Thread(thread1);

        Thread thread02=new Thread(thread2);

        thread02.start();
        thread01.start();

        System.out.println(Thread.currentThread().getName());
        for (int i=0;i<100;i++){
            System.out.println("Hii Pratik : : "+i);
        }






    }
}
