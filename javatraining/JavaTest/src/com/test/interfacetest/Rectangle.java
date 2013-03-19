package com.test.interfacetest;

public class Rectangle implements Shape {
	private double width;
	private double length;
	private double area;
	
	public Rectangle(double l, double w){
		length =l;
		width = w;		
	}
	
	public double calculateArea(){
		area = length*width;
		return area;
}
}
