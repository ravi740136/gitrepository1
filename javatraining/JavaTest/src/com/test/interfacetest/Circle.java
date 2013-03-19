package com.test.interfacetest;

public class Circle implements Shape{
	double radius;
	double area;
	public double calculateArea(){
		area = pi*radius*radius;
		return area;
	}	
	public Circle(double radius){
		this.radius = radius;
	}

}
