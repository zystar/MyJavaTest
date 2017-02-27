package com.test.algorithm.classic;

import java.util.Scanner;

/**
 * @author STAR
 * 输入两个正整数m和n，求其最大公约数和最小公倍数。
 * 1.程序分析：利用辗除法。
 */
public class Main5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println("最大公约数：" + gcd(a, b));
		System.out.println("最小公倍数" + lcm(a, b));
	}
	
	//最大公约数
	static int gcd(int a, int b){
		int r;
		if(a < b){//保证a>=b
			int tmp = a;
			a = b;
			b = tmp;
		}
		while(a % b > 0){
			r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
	
	//最小公倍数
	static int lcm(int a, int b){
		return a * b /gcd(a, b);
	}
}
