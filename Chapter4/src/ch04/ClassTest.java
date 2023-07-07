package ch04;

import java.lang.reflect.Constructor;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c1 = Class.forName("ch04.Person");
		
		Person person = (Person)c1.newInstance();
		
		person.setName("kim");
		System.out.println(person);
		
		Class c2 = person.getClass();
		Person p = (Person)c2.newInstance();
		System.out.println(p);
		
		Class[] parameterTypes = {String.class};
		Constructor<T> cons = c2.getConstructor(parameterTypes);
		
		Object[] initargs = {"kim"};
		Person kim = (Person)cons.newInstance(initargs);
		System.out.println(kim);
		
		}

}
