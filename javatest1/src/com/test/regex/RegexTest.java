package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	Pattern p;
	Matcher m;
	
	public RegexTest(String s){
		p = Pattern.compile("\\w+");
		m = p.matcher(s);
		
	}

	public void flagstest(){
		System.out.println(p.flags());
	}
	
	public void patternMatchingTest(){
		System.out.println("group count "+m.groupCount());
		m.find(4);
		while (m.find()){
		//	System.out.println(m.start());
		//	System.out.println(m.end());
			System.out.println(m.group()+" start: "+m.start()+" end: "+m.end());
		}
		System.out.println("group count "+m.groupCount());
		if (m.matches()){
			System.out.println("match found");
		}
			
	}
}
