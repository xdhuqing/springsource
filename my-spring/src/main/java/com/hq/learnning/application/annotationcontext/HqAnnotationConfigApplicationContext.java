package com.hq.learnning.application.annotationcontext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HqAnnotationConfigApplicationContext {

	public static void main(String[] args) {
		/**
		 * 启动容器：容器初始化
		 * 方式1 注册配置类：直接将注解 Bean 注册到容器中
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(HqAnnotationTest.class);
		context.refresh();

		/**
		 * 启动容器：容器初始化
		 * 方式2 传入扫描路径：通过扫描指定的包及其子包下的所有类
		 */
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.hq.learnning.application.annotationcontext");


		/**
		 *  此时容器持有BD，并实例化所有普通单例bean（特殊:lazy-init=true，以及其他scope不会被实例化）
		 *  已完成：Bean定义资源的定位、载入和注册；普通单例实例化；依赖注入；aop代理
		 */

		//特殊:BF与AC不同，不会预实例化bean

		/**
		 * 获取bean实例：
		 * 功能：
		 * 实例化非普通单例bean
		 * 非普通单例依赖注入
		 */
		HqEntity bruce = context.getBean("bruce", HqEntity.class);
		bruce.hello();

		HqEntity alice = context.getBean("alice", HqEntity.class);
		alice.hello();



	}

}
