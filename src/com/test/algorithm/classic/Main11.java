package com.test.algorithm.classic;

/**
 * @author STAR
 * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 */
public class Main11 {

	public static void main(String[] args) {
		char buf[] = {'1', '2', '3', '4'};
		perm(buf, 0, buf.length - 1);
	}
	
	static void perm(char[] buf, int start, int end){
		if(start == end){//递归出口
			for (int i = 0; i < end; i++) {
				System.out.print(buf[i]);
			}
			System.out.println();
		}else{//递归
			for (int i = start; i <= end; i++) {//让指针start分别指向每一个数
				char temp = buf[start];//交换数组第一个元素和后续的元素
				buf[start] = buf[i];
				buf[i] = temp;
				perm(buf, start + 1, end);//后续元素递归全排列
				
				temp = buf[start];//将交换后的数组还原
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}

}
