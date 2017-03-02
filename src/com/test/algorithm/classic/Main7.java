package com.test.algorithm.classic;

import java.util.Scanner;

/**
 * @author STAR
 * 输入一行字符，分别统计出其中英文字母、汉字、数字和其它字符的个数。
 * 1.程序分析：利用while语句,条件为输入的字符不为 '\n '.
 */
public class Main7{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String E1 = "[\u4e00-\u9fa5]";
		String E2 = "[a-zA-Z]";
		String E3 = "[0-9]";
		int countH = 0;//汉字
		int countE = 0;//字母
		int countI = 0;//数字
		int countO = 0;//其他字符
		char[] arrChar = str.toCharArray();
		String[] arrStr = new String[arrChar.length];
		for (int i = 0; i < arrStr.length; i++) {//转为字符串
			arrStr[i] = String.valueOf(arrChar[i]);
		}
		for(String i : arrStr){
			if(i.matches(E1)){
				countH++;
			}else if(i.matches(E2)){
				countE++;
			}else if(i.matches(E3)){
				countI++;
			}else{
				countO++;
			}
		}
		System.out.println("汉字的个数" + countH);
		System.out.println("字母的个数" + countE);
		System.out.println("数字的个数" + countI);
		System.out.println("其他字符的个数" + countO);
	}

}
