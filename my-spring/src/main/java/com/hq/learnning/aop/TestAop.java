package com.hq.learnning.aop;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@EnableAspectJAutoProxy
public class TestAop {

	public static void main(String[] args) {

		/**
		 * 测试
		 *
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("aspectjTest.xml");
		TargetBean bean = (TargetBean) context.getBean("targetBean");
		bean.test();


		/**
		 * 开启aop
		 * xml：
		 * < aop:aspectj-autoproxy/>
		 * 注解：
		 * @EnableAspectJAutoProxy
		 */


		//探索原理

		/**
		 * 1 通过aspectj-autoproxy全局搜索找到解析位置
		 * AopNamespaceHandler
		 * registerBeanDefinitionParser("aspectj-autoproxy", new AspectJAutoProxyBeanDefinitionParser());
		 *
		 */
		AopNamespaceHandler aopNamespaceHandler;
		// AspectJAutoProxyBeanDefinitionParser //---protected

		/**
		 * 2 AspectJAutoProxyBeanDefinitionParser
		 * public BeanDefinition parse(Element element, ParserContext parserContext)
		 */

		/**
		 * 3 parse
		 * 3.1 注册AspectJAnnotationAutoProxyCreator
		 *   AopNamespaceUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(parserContext, element);
		 * 3.2 处理子类
		 *   extendBeanDefinition(element, parserContext);
		 */


		/**
		 * 3.1 AopNamespaceUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary
		 * 3.1.1  获取BD：
		 *    BeanDefinition beanDefinition = AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(
		 * 				parserContext.getRegistry(), parserContext.extractSource(sourceElement));
		 *
		 * 		如果registry已存在"org.springframework.aop.config.internalAutoProxyCreator"
		 * 	       return null
		 * 	    否则
		 * 	       new RootBeanDefinition(cls);//cls为固定的AnnotationAwareAspectJAutoProxyCreator
		 * 		   注册为"org.springframework.aop.config.internalAutoProxyCreator"
		 * 		   return bd
		 *
		 * 3.1.2  useClassProxyingIfNecessary(parserContext.getRegistry(), sourceElement);
		 *   特殊处理
		 *     "proxy-target-class"--决定是基于接口的还是基于类的代理被创建;为true则是基于类的代理将起作用（需要cglib库），为false或者省略这个属性，则优先JDK动态代理
		 *     "expose-proxy"--解决被代理类内部方法间调用不会被代理问题。特别是事务
		 *  扩展：使用 <aop:config proxy-target-class=true> ... </aop:config>
		 *
		 *
		 * 3.1.3   registerComponentIfNecessary(beanDefinition, parserContext);
		 *   注册组件并通知
		 *
		 */
		AnnotationAwareAspectJAutoProxyCreator aaaapc;


		/**
		 * 3.2 extendBeanDefinition(element, parserContext)
		 * 处理aop:aspectj-autoproxy的子标签aop:include的，
		 * 目的是把include的name属性取出来设置到代理创建器的 includePatterns 属性中
		 *
		 * 这个includePatterns是用来过滤aspect的
		 *   (1)如果没有配置则所有被@Aspect修饰的对象都生效;
		 *   (2)如果配置了，则aspect对象名称必须至少满足一个include name的规则(正则表达式)，
		 * 这些从includePatterns使用的地方就可以知道:
		 * AnnotationAwareAspectJAutoProxyCreator.isEligibleAspectBean(String beanName)
		 *
		 */
		// ------------------------------------------

		/**
		 * 4 创建AOP代理
		 * AnnotationAwareAspectJAutoProxyCreator
		 * 实现了BeanPostProcessor，从postProcessAfterInitialization开始分析
		 *
		 */
		AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator;
		BeanPostProcessor beanPostProcessor;

		/**
		 * 4.1 postProcessAfterInitialization
		 *
		 * 4.1.1 wrapIfNecessary
		 *    4.1.1.1过滤不需要包装的情况：已处理、非代理对象、基础类、skip
		 *    4.1.1.2获取增强：getAdvicesAndAdvisorsForBean
		 *    4.1.1.3创建代理：createProxy
		 *
		 * 4.1.1.2获取增强：getAdvicesAndAdvisorsForBean
		 *   获取所有beanname
		 *   遍历找出带有aspectj注解的类（持有父引用，优先掉用）
		 *   解析出增强 ---TODO待深入分析
		 *
		 *   加入缓存
		 *
		 *   增强：引介增强和普通增强
		 *   普通增强：前置、后置、环绕、最终、异常等增强形式，它们的增强对象都是针对方法级别的
		 *   引介增强：则是对类级别的增强，我们可以通过引介增强为目标类添加新的属性和方法
		 *
		 * 4.1.1.3创建代理：createProxy
		 *   获取当前类的属性
		 *   添加代理接口（非强制cglib情况下）
		 *   封装Advisor到ProxyFactory中
		 *   设置要代理的类
		 *   定制化---扩展点
		 *   获取代理
		 *      如果目标实现了接口，默认JDK动态代理
		 *      如果目标实现了接口，可以强制使用CGLIB
		 *      如果目标没有实现接口，必须用CGLIB
		 *
		 *
		 *
		 */

		DefaultAopProxyFactory defaultAopProxyFactory;




	}
}
