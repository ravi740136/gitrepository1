package com.test.integertest;

public class IntegerTest {
	Integer I;
	public IntegerTest(String s){
		I = new Integer(s);
	}

	public IntegerTest(int i){
		I = new Integer(i);
	}
	
	public void decodeTest(String s){
		
		//USES the prefix like 0X to identify the format
		Integer I = Integer.decode(s);
		System.out.println("Integer Value: "+I);
		
		I = Integer.valueOf(s, 16);
		System.out.println("radix 16 Integer Value: "+I);
		
		System.out.println("Integer converted to hex string: "+Integer.toString(I,16));
		System.out.println("Integer converted to hex string USING HEXSTRING: "+Integer.toHexString(I));
		System.out.println("Hexadecimal string to int value: "+Integer.parseInt(s, 16));
		
		I = Integer.valueOf(s, 2);
		System.out.println("radix 2 Integer Value: "+I);
		
		I = Integer.valueOf(s, 8);
		System.out.println("radix 8 Integer Value: "+I);
	}

}
