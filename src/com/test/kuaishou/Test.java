package com.test.kuaishou;

/**
 * 快手2017校招
 * @author STAR
 *
 */
public class Test {

	public static void main(String[] args) {
		f1();
	}
	

	/*
	 * 将字符串转为数字。这个主要注意异常处理
	 */
	static void f1(){
		String a = "a1";
		try{
			int b = Integer.valueOf(a);
			System.out.println(b);
		}catch(NumberFormatException e){
			System.out.println("字符转换异常");
		}	
	}
	
}
