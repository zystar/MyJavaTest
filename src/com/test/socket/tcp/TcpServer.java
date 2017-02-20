package com.test.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author STAR
 * 用来演示服务器的连接请求队列的特性 --服务端
 * 参考：http://blog.csdn.net/qq_23473123/article/details/51461894#comments
 */
public class TcpServer {
	private int port = 1122;
	private ServerSocket serverSocket;
	
	public TcpServer() throws Exception{
		serverSocket = new ServerSocket(port, 3);
		System.out.println("服务启动！");
	}
	
	public void service(){
		while(true){
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				System.out.println("New connection accepted " + 
				socket.getInetAddress() + ":" + socket.getPort());
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(socket != null){
					try{
						socket.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		TcpServer server = new TcpServer();
//		Thread.sleep(60000 * 10);
		server.service();
	}

}
