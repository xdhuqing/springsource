package com.hq.learnning.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAdvice {

	@Pointcut("execution(* *.test(..))")
	public void pointcut(){

	}



	@Before("pointcut()")
	public void beforeTest(){
		System.out.println("before test");
	}


}
