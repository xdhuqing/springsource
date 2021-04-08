package com.hq.learnning.beans;

public class MyPojoWithProperty {

	private String name;


	public void hello(){
		System.out.println(String.format("hi, my name is %s", this.name));
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
