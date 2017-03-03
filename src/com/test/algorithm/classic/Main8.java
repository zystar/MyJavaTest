package com.test.algorithm.classic;

import java.util.Scanner;

/**
 * @author STAR
 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 * 1.程序分析：关键是计算出每一项的值。
 */
public class Main8 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int sum = 0;
		int t = 0;
		for (int i = 0; i < a; i++) {
			t = t * 10 + a;
			sum += t;
		}
		System.out.println(sum);
		sc.close();
	}
}
