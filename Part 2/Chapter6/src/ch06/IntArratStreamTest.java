package ch06;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArratStreamTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		for(int num : arr) {
			System.out.println(num);
		}
		
		System.out.println();
		IntStream is = Arrays.stream(arr);
		is.forEach(n->System.out.println(n));
		
		is = Arrays.stream(arr);
		int sum = is.sum();
		
		System.out.println(sum);
		
	}

}
