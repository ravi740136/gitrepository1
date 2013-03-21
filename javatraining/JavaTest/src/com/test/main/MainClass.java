package com.test.main;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.test.collectiontest.*;
import com.test.inheritancetest.BClass;
import com.test.inheritancetest.EClass1;
import com.test.interfacetest.InterfaceTest;
import com.test.iteratortest.ListIteratorTest;
import com.test.reflectionstest.ReflectionsTest;
import com.test.selenium.DriverTest;
import com.test.selenium.XpathTest;
import com.test.sql.SQLTest;

public class MainClass {


	public static void main(String[] args) throws SQLException  {
		try{
SQLTest.getConnection();
SQLTest.insertData();
SQLTest.getAndprintData();
		}
		finally{
			SQLTest.shutdown();
		}
	
	}

}
