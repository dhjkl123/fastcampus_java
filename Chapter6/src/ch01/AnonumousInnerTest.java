package ch01;

class Outer2{
	
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnalbe(int i) {
		int Num = 10;
		
		return new Runnable() {
			
			int localNum = 1000;
			@Override
			public void run() {
				
				
				System.out.println("i : " +  i);
				System.out.println("Num : " +  Num);
				System.out.println("outNum : " +  outNum);
				System.out.println("sNum : " +  sNum);
				System.out.println("localNum : " +  localNum);
				
			}
			
		};
			
	}
	
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}


public class AnonumousInnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer2 out = new Outer2();
		Runnable runner = out.getRunnalbe(10);
		runner.run();
		
		out.runnable.run();
		

	}

}
