package com.test.temp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class SimpleClass implements Externalizable {
public int i = 500;
public String s = "test raviu";
@Override
public void writeExternal(ObjectOutput out) throws IOException {
	// TODO Auto-generated method stub
	
}
@Override
public void readExternal(ObjectInput in) throws IOException,
		ClassNotFoundException {
	// TODO Auto-generated method stub
	
}
}
