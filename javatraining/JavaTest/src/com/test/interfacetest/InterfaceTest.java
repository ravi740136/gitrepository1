package com.test.interfacetest;

import java.util.ArrayList;
import java.util.List;

import com.test.interfacetest2.Square;

public class InterfaceTest{
	Shape s1 = new Square(5.6);
	Shape s2 = new Rectangle(5,6);
	Shape s3 = new Circle(6.5);
	List<Shape> ls = new ArrayList<Shape>();
	double area;
	public void printArea(){
		ls.add(s1);
	
		ls.add(s2);
		ls.add(s3);
		
		for (Shape s:ls){
			 area += s.calculateArea();			
		}
		System.out.println(area);
		
		
	}
	
	
}
