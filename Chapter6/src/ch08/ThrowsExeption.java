package ch08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsExeption {
	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}

	public static void main(String[] args) {
		ThrowsExeption test = new ThrowsExeption();
		


			try {
				test.loadClass("a.txt", "abc");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		
		System.out.println("end");

	}

}
