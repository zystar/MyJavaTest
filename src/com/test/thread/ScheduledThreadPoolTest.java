package com.test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author STAR
 * 创建一个定长线程池，支持定时及周期性任务执行
 */
public class ScheduledThreadPoolTest {
	public static void main(String[] args){
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);//表示延迟3秒执行
	}
}
