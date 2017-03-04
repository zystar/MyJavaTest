package com.test.algorithm.classic;

/**
 * @author STAR
 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Main10 {
	public static void main(String[] args){
		double t = 100;
		double s = t;
		for (int i = 0; i <= 10; i++) {
			s += t;
			t = t / 2;
		}
		System.out.println(s - t);
		System.out.println(t);
	}
}
