package com.hq.learnning.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class TestBeanFactoryAware implements BeanFactoryAware {

	private BeanFactory bf;


	public TestBeanFactoryAware() {
		System.out.println("constructor of TestBeanFactoryAware is called!!!");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory is called ");
		this.bf = beanFactory;
	}


	public void myBf(){
		System.out.println(String.format("my name is %s", this.bf.getBean(this.getClass()).myName()));
	}

	public String myName(){
		return "bruse";
	}

}
