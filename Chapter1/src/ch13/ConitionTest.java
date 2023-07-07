package ch13;

import java.util.Scanner;

public class ConitionTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력1");
		int num1 = scanner.nextInt();
		
		System.out.println("입력2");
		int num2 = scanner.nextInt();
		
		int max =(num1 > num2) ? num1 : num2;
		System.out.println(max);
	}

	

}
