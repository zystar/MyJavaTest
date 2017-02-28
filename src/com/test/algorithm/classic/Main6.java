package com.test.algorithm.classic;

/**
 * @author STAR
 *	海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，
 *  多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，
 *  又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，
 *  问海滩上原来最少有多少个桃子？
 */
public class Main6 {
	public static void main(String[] args){
		int amountOfMonkey = 5;//猴子总数
		int amount = 0;//最少桃子数
		int x = amountOfMonkey - 1;//最后一只猴子分完剩下的
		boolean flag = false;//是否得到答案
		while(!flag){
			amount = x;
			for (int i = amountOfMonkey; i > 0; i--) {
				if(amount % (amountOfMonkey - 1) != 0){//是否可被分
					break;
				}
				//前一只猴子分之前的桃子数
				amount = amount / (amountOfMonkey - 1) * amountOfMonkey + 1;
				if(1 == i){
					flag = true;
					System.out.println(amount);
				}
				//最后一个猴子分完剩下的桃子数比为amountOfMonkey-1的倍数
				x += amountOfMonkey - 1;//改变最后一个猴子分完剩下的桃子数
			}
		}
	}
}
