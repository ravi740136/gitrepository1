package com.test.BooleanTest;

public class BooleanTest {
	Boolean B;
	public BooleanTest(String s){
		B = new Boolean(s);
	}
	
	public BooleanTest(boolean b){
		B = new Boolean(b);
	}
	
	public void Boolean_String(){
		String s = B.toString();
		System.out.println("String value of Boolean object "+s);
		B = Boolean.valueOf("true");
		System.out.println("Boolean Object value of String true "+B);
		B = Boolean.valueOf("TRUE");
		System.out.println("Boolean Object value of String TRUE "+B);
				B = Boolean.valueOf("false");
		System.out.println("Boolean Object value of String false "+B);
		B = Boolean.valueOf("FLASE");
System.out.println("Boolean Object value of String FALSE "+B);
		B = Boolean.valueOf("True");
System.out.println("Boolean Object value of invalid string "+B);
	}

	public void boolean_String(){
		boolean b =true;
		String s = Boolean.toString(b);
		System.out.println("String value of primitive boolean "+s);
		b = Boolean.parseBoolean("true");
		System.out.println("boolean value of String true "+b);
				b = Boolean.parseBoolean("false");
		System.out.println("boolean value of String false "+b);
		b = Boolean.parseBoolean("TRUE");
		System.out.println("boolean value of String TRUE "+b);
				b = Boolean.parseBoolean("FALSE");
		System.out.println("boolean value of String FALSE "+b);
		b = Boolean.valueOf("TRUE");
System.out.println("boolean value of String invalid string "+b);
	}
	
	public void Boolean_boolean(){
		boolean b = B.booleanValue();	
		System.out.println("String value of boolean value obtained from Boolean object "+Boolean.toString(b));
		B = Boolean.valueOf(b);
		System.out.println("Boolean Object value of boolean true "+B);
		
	}
	
	public void comparetest(){
		Boolean B1 = new Boolean (false);
		System.out.println("Bolean objects comparison "+ B.compareTo(B1));
		boolean b = false;
		boolean b1 = true;
		System.out.println("boolean values comparison "+ Boolean.compare(b,b1));
	
	}

}
