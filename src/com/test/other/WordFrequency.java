package com.test.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author STAR
 * 统计一段英文中单词出现的次数
 * 参考：http://blog.csdn.net/justforworld/article/details/52960103
 */
public class WordFrequency {

	public static void main(String[] args) {
		System.out.println("输入一段英文：");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//定义一个数组来接收切割的字符串
		String[] strarr = str.split(" ");
		System.out.println(strarr.length);
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		for(String ss : strarr){
			if(!map.containsKey(ss)){
				map.put(ss, 1);
			}else{
				Integer count = map.get(ss);
				count ++;
				map.put(ss, count);
			}
		}
		Set<String> set = map.keySet();
		System.out.println(set.size());
		//遍历map
		for(Map.Entry<String, Integer> mm : map.entrySet()){
			System.out.println(mm.getKey() + "---" + mm.getValue());
		}
	}

}
