package com.test.socket.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author STAR
 * 用来演示服务器的连接请求队列的特性 --客户端
 * 参考：http://blog.csdn.net/qq_23473123/article/details/51461894#comments
 */
public class TcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		final int length = 100;
		String host = "localhost";
		int port = 1122;
		Socket[] socket = new Socket[length];
		
		for (int i = 0; i < length; i++) {
			socket[i] = new Socket(host, port);
			System.out.println("第" + (i + 1) + "次连接成功！");
		}
		Thread.sleep(3000);
		for (int i = 0; i < length; i++) {
			socket[i].close();
		}
	}

}
