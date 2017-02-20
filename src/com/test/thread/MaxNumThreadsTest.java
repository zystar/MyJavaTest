package com.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author STAR
 * 此类用于测试当前环境可创建的最大线程数
 * 此类运行后主机内存直接98%，电脑卡死，需要强制关机，线程数达到6w以上
 */
public class MaxNumThreadsTest {

	public static void main(String[] args) {
		
		for (int i = 0; ; i++) {
			System.out.println("i = " + i);
			new Thread(new HoldThread()).start();
		}
	}

}

class HoldThread extends Thread{
	CountDownLatch cdl = new CountDownLatch(1);
	
	public HoldThread(){
		this.setDaemon(true);
	}
	
	public void run(){
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}