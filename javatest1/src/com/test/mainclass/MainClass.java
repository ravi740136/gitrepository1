package com.test.mainclass;





import org.testng.annotations.Test;

import com.test.calendartest.CalendarTest;
import com.test.enumtest.EnumTest;
import com.test.enumtest.EnumTest.WeekDays;
import com.test.regex.RegexTest;
import com.test.integertest.*;

public class MainClass {
	
	@Test(enabled=false)
	public void calendarFieldTest(){
		CalendarTest.printCalendarFields();
	}
	
	@Test(enabled=false)
	public void regexFlagsTest(){
		RegexTest r = new RegexTest("T1_f 1112#j2222");
		r.patternMatchingTest();
		
	}
	
	
	@Test(enabled=false)
	public void BooleanTest(){
		com.test.BooleanTest.BooleanTest BT = new com.test.BooleanTest.BooleanTest(true);
		BT.comparetest();
		
	}
	
	
	@Test(enabled=false)
	public void IntegerTest(){
		IntegerTest IT = new IntegerTest("12");
		IT.decodeTest("11");
		
	}
	
	@Test(enabled=true)
	public void EnumSwitchTest(){
		EnumTest.enum_switch_test(WeekDays.SUNDAY);		
	}

}
