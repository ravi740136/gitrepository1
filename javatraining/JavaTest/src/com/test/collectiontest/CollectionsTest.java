package com.test.collectiontest;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class CollectionsTest {
	private static List<Integer> myList = new ArrayList();
	private static List<String> myUPDList = new ArrayList<String>();
	private static List<String> sortedCopymyUPDList = new ArrayList<String>();
	public static void createArrrayList(){
		for (int i = 0; i<10 ; i++){
			myList.add(new Random().nextInt());
		}
	}
	
	public static void createArrrayList1(){
		for (int i = 0; i<10 ; i++){
			myList.add(i+4);
		}
	}
	
	public static void createArrrayList2(){
		
			myUPDList.add("DNU".toLowerCase());
			myUPDList.add("UPD".toLowerCase());
			myUPDList.add("SUSP".toLowerCase());
			myUPDList.add("UPDSS".toLowerCase());
			
		
	}
	
	public static void printArrayList(List a){
		System.out.println("printing the values in the list");
		for (int i = 0; i< a.size(); i++){
			System.out.println(a.get(i));
		}
	}
	
	public static void sortTest(){
		createArrrayList1();
		Collections.shuffle(myList);
		printArrayList(myList);
		Collections.sort(myList);
		printArrayList(myList);
	}
	
	public static int searchPosition(String I){
		createArrrayList2();	
	//	Collections.copy(myUPDList,sortedCopymyUPDList);
		List<String> test= new ArrayList<String>(myUPDList);
	
		
		Collections.sort(test);
		printArrayList(test);
		return Collections.binarySearch(test, I);
		
	}
	
	public static void ncopiesTest(){
		List<Integer> nci = Collections.nCopies(10, 10);
		myUPDList.add("ravi");
		myUPDList.add("ravi");
		myUPDList.add("ravi");
		myUPDList.add("ravi");
		Collections.fill(myUPDList, "test");
		printArrayList(myUPDList);
	}
	
	public static void MinMaxTest(){
	createArrrayList1();
	
		Collections.shuffle(myList);
		printArrayList(myList);
		System.out.println("max is "+ Collections.max(myList));
		System.out.println("min is "+ Collections.min(myList));
	}
}
