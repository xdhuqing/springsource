package com.hq.learnning.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.FactoryBeanRegistrySupport;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public class BeanFactories {

	public static void main(String[] args) {

		/**
		 * 核心类
		 */
		DefaultListableBeanFactory defaultListableBeanFactory;
		XmlBeanDefinitionReader xmlBeanDefinitionReader;
		DefaultBeanDefinitionDocumentReader defaultBeanDefinitionDocumentReader;

		/**
		 * 测试
		 */

//		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		/**
		 * The type XmlBeanFactory is deprecated，XmlBeanFactory在3.1以后已经被废弃
		 * 运行报错
		 *
		 * public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
		 * 		super(parentBeanFactory);
		 * 		this.reader.loadBeanDefinitions(resource);
		 * }
		 *
		 */

		Resource resource=new ClassPathResource("beanFactoryTest.xml");
		BeanFactory bf=new DefaultListableBeanFactory();
		BeanDefinitionReader bdr=new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
		bdr.loadBeanDefinitions(resource);

		System.out.println("before getBean----");
		//---------------------------------
		MyPojo pojo = bf.getBean(MyPojo.class);
		pojo.hello();
		MyPojoWithProperty myPojoWithProperty = bf.getBean(MyPojoWithProperty.class);
		myPojoWithProperty.hello();

		/**
		 * ignoreDependencyInterface
		 * eg:BeanFactoryAware beanFactoryAware;
		 */
		System.out.println("--------------ignoreDependencyInterface--------------");
		System.out.println("to call getBean");
		TestBeanFactoryAware testBeanFactoryAware = bf.getBean(TestBeanFactoryAware.class);
		System.out.println("to call myBf");
		testBeanFactoryAware.myBf();


		/**
		 * xml --- Resource ---- InputStream ----- InputSource
		 *   ----- Document ------BeanDefinition
		 */
		InputSource inputSource;//org.xml.sax
		DefaultDocumentLoader defaultDocumentLoader;
		EntityResolver entityResolver;//实现离线加载XML验证文档

		/**
		 * 解析Bean
		 * 委托BeanDefinitionParserDelegate解析各种element
		 */
		BeanDefinitionParserDelegate beanDefinitionParserDelegate;


		BeanDefinition beanDefinition;
		BeanDefinitionHolder beanDefinitionHolder;
		/**
		 * FactoryBean
		 */
		FactoryBeanRegistrySupport factoryBeanRegistrySupport;

	}
}
