package com.test.thread;

import java.util.concurrent.atomic.AtomicInteger;  
  
/**
 * @author STAR
 * 测试一个jvm实例可以开多少个线程
 */
public class JVMThreadsTest extends Thread {  
    private static final AtomicInteger count = new AtomicInteger();  
  
    public static void main(String[] args) {  
        while (true)  
            (new JVMThreadsTest()).start();  
  
    }  
  
    @Override  
    public void run() {  
        System.out.println(count.incrementAndGet());  
  
        while (true)  
            try {  
                Thread.sleep(Integer.MAX_VALUE);  
            } catch (InterruptedException e) {  
                break;  
            }  
    }  
} 