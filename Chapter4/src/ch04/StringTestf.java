package ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StringTestf {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("java.lang.String");
		
		Constructor[] cons = c.getConstructors();
		for(var co : cons) {
			System.out.println(co);
		}
		
		Method[] m = c.getMethods();
		for(var mth : m) {
			System.out.println(mth);
		}
	}

}
