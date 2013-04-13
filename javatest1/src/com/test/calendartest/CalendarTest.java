package com.test.calendartest;

import java.util.Calendar;

public class CalendarTest {
	static Calendar c = Calendar.getInstance();
	static{
		c.add(Calendar.DATE, 19);
	}
	public static void printCalendarFields(){
		System.out.println("day of month "+ c.get(Calendar.DAY_OF_MONTH));
		System.out.println("day of week "+ c.get(Calendar.DAY_OF_WEEK));
		System.out.println("month "+ c.get(Calendar.MONTH));
		System.out.println("week of month "+ c.get(Calendar.WEEK_OF_MONTH));
		System.out.println("day of year "+ c.get(Calendar.DAY_OF_YEAR));
		System.out.println("day of week in month "+ c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("date "+ c.get(Calendar.DATE));
		System.out.println("hour of day "+ c.get(Calendar.HOUR_OF_DAY));
		System.out.println("hour "+ c.get(Calendar.HOUR));
		System.out.println("week of year "+ c.get(Calendar.WEEK_OF_YEAR));
		System.out.println("year "+ c.get(Calendar.YEAR));
		System.out.println("minute "+ c.get(Calendar.MINUTE));
		System.out.println("second "+ c.get(Calendar.SECOND));
	}
	

}
