package com.hq.learnning.application.xmlcontext;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContextMain {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");


		AbstractRefreshableApplicationContext abstractRefreshableApplicationContext;


		DefaultListableBeanFactory defaultListableBeanFactory;
	}


}
