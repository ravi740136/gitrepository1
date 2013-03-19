package com.test.interfacetest2;

import com.test.interfacetest.*;

public class Square implements Shape {
	double area;
	double length;

	@Override
	public double calculateArea() {
		area = 4 * length;
		return area;
	}

	public Square(double length) {
		this.length = length;
	}
}
