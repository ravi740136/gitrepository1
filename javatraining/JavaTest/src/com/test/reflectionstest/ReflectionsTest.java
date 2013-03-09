package com.test.reflectionstest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import com.test.collectiontest.*;

public class ReflectionsTest {

public static int classTest(String s) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
	Class<CollectionsTest> c1 = (Class<CollectionsTest>) Class.forName("com.test.collectiontest.CollectionsTest");
	Class<CollectionsTest> c = (Class<CollectionsTest>) com.test.collectiontest.CollectionsTest.class;
	if (c1.equals(c)){
		System.out.println("true"+c);
	}
	Object o = c.newInstance();

	System.out.println(c1.getName());
	System.out.println(c1.getCanonicalName());
	System.out.println(c1.getSimpleName());
	System.out.println("c1 modifiers " + c1.getModifiers());
	System.out.println(c1.getDeclaredConstructors().length);
	Constructor[] cona = c1.getDeclaredConstructors();
	for (Constructor con:cona){
		System.out.println("constructor "+con.getName());
		System.out.println("constructor "+con.getParameterTypes().length);
		System.out.println("constructor modifiers "+con.getModifiers());
		System.out.println("constructor modifiers "+con.getDeclaringClass().getName());
	}
	Method m = c.getMethod("searchPosition", new Class[]{String.class});
	if (m != null){
		return (Integer)m.invoke(o, s);
	}
	return -1000;
}

public static void classComponentsTest() throws NoSuchFieldException, SecurityException, ClassNotFoundException{
	@SuppressWarnings("unchecked")
	Class<CollectionsTest> c1 = (Class<CollectionsTest>) Class.forName("com.test.collectiontest.CollectionsTest");
	Class<CollectionsTest> c2 = (Class<CollectionsTest>) com.test.collectiontest.CollectionsTest.class;
	if (c1.equals(c2)){
		System.out.println("true"+c2);
	}
	Class c= SampleClass.class;	

	Field[] fa = c.getDeclaredFields();
	for (Field f:fa){
	if (f.getType().isArray()){
		System.out.println("field array " + f.getType().getSimpleName());
		System.out.println("field array of " + f.getType().getComponentType().getSimpleName());
	}
	else if (f.getType().getName().toLowerCase().contains("list")){
		System.out.println("field list type " + f.getType().getSimpleName());
	} 
	else {
		System.out.println("field simple type " + f.getType());
	System.out.println("field modifiers " + f.getModifiers());
	}
	}
Method m[] = c.getDeclaredMethods();
for (Method m1:m){
	Class[] pc = m1.getParameterTypes();
	if (pc[0].isArray()){
		System.out.println("Parameter array component type is "+pc[0].getComponentType());
	}
	else if (pc[0].getName().toLowerCase().contains("list")){
		System.out.println("parameter list type is "+pc[0].getName());
	}
	else System.out.println("parameter simple type is" + pc[0].getName());
}
}


}
