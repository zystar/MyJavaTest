package com.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author STAR
 *	参考：http://www.cnblogs.com/xing901022/p/3963962.html
 */
public class SpringDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");//读取bean.xml内容
		Person p = ctx.getBean("person", Person.class);//创建bean的引用对象
		p.info();
	}

}
