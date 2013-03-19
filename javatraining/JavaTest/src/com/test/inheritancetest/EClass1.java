package com.test.inheritancetest;

public class EClass1 extends BClass{
	public int i = 20;
	
	
	public EClass1(){
		i += 5;
	}
	
	@Override
	public void print(){
	System.out.println("printing from EClass1 "+i);
	}
}
