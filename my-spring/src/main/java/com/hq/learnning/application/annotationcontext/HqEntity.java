package com.hq.learnning.application.annotationcontext;

public class HqEntity {
	private String name;


	public void hello(){
		System.out.println(String.format("hi ,my name is %s", name));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
