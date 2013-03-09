package com.test.iteratortest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
	private static List<Integer> l = new ArrayList<Integer>();
	
	static{
		int i=0;
		while (i<18){
			l.add(i+1);
			i++;
		}
	}
	
	public static void listIteratorTest(){
	ListIterator<Integer> li = l.listIterator();
	
	while (li.hasNext()){
		System.out.println(li.next()+" "+li.nextIndex());
	}
	
	while (li.hasPrevious()){
		System.out.println(li.previous()+" "+li.previousIndex());
	}
	}

}
