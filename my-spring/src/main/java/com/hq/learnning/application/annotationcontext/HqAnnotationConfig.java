package com.hq.learnning.application.annotationcontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HqAnnotationConfig {


	@Bean("bruce")
	public HqEntity hqEntity(){
		HqEntity hqEntity = new HqEntity();
		hqEntity.setName("bruce");
		return hqEntity;
	}

	@Bean("alice")
	public HqEntity hqEntity2(){
		HqEntity hqEntity = new HqEntity();
		hqEntity.setName("alice");
		return hqEntity;
	}

}
