package com.test.reflectionstest;

import java.util.ArrayList;
import java.util.List;

public class SampleClass {
	public static final int i=20;
	private Integer iz;
	private int ia[] = new int[10];
	private Integer iza[] = new Integer[10];
	private List<Integer> izl = new ArrayList<Integer>();
	
	
	public int multiply(Integer a[]){
		this.iza = a;
		return iza.length;
	}

	public int multiplyl(List<Integer> al){
		this.izl = al;
		return izl.size();
	}
}
