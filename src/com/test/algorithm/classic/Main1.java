package com.test.algorithm.classic;

/**
 * @author STAR
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第四个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 * 程序分析:兔子的规律为数列1,1,2,3,5,8,13,21....
 */
public class Main1 {

	public static void main(String[] args) {
		for(int i = 1; i <= 20; i++){
			System.out.println(foo(i));
		}
	}
	//x为第x个月
	public static int foo(int x){
		if(x == 1 || x == 2){
			return 1;
		}else{
			return foo(x - 1) + foo(x - 2);
		}
	}

}
