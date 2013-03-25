package com.test.io1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.test.temp.SimpleClass;

public class io1Test {
	FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fis;
	ObjectInputStream ois;
	public io1Test() throws IOException{
		File f = new File("C:\\mylocaldata\\temp\\test1");
		f.createNewFile();
		fos = new FileOutputStream(f);
		fis = new FileInputStream(f);
		oos = new ObjectOutputStream(fos);
		ois =  new ObjectInputStream(fis);
	}
	
	public void createStream() throws IOException{
	
		oos.writeObject(new SimpleClass());
	}

	public void readData() throws IOException, ClassNotFoundException{

	
	SimpleClass sc = (SimpleClass) ois.readObject();
	System.out.println(sc.i+" "+sc.s);
	}

}
