package com.test.enumtest;
public class EnumTest {
	public enum WeekDays{
		SATURDAY("a"), SUNDAY("b"), MONDAY("c");		
		private String w;
		private WeekDays(String i){
			this.w=i;
		}
		public String get(){
			return w;
		}

	}

	
	public static void enum_switch_test(WeekDays day){
		
		switch (day.get())
		{
		case "a":
			System.out.println("Today is saturday");
			break;
		case "b":
			System.out.println("Today is sunday");
			break;
		default:
			System.out.println("Today is working day");	
			break;
		}
	}
	

}
