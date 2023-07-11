package ch20;

public class NestedLoopTest {

	public static void main(String[] args) {
		
		
		for(int dan = 2;dan<10;dan++)
		{
			for(int count = 1 ; count<10;count++)
			{
				System.out.println(dan + "X" + count + "=" + dan*count);
			}
			
			System.out.println();
			
		}
		
		
		int dan = 2;
		while(dan<10) {
			
			int count = 1;
			while(count<10)
			{
				System.out.println(dan + "X" + count + "=" + dan*count);
				count++;
			}
			System.out.println();
			dan++;
		}
		
		
	}

}
