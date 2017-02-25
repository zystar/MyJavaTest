package com.test.algorithm.classic;

/**
 * @author STAR
 * 判断101-200之间有多少个素数，并输出所有素数。    
 * 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
 */
public class Main2 {

	public static void main(String[] args) {
		int start = 101;
		int end = 200;
		int count = 0;
		for (int i = start; i <= end; i++) {
			if(isPrime(i)){
				System.out.println(i);
				count ++;
			}
		}
		System.out.println("count:" + count);
	}
	static boolean isPrime(int x){
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0)
				return false;
		}
		return true;
	}
}
