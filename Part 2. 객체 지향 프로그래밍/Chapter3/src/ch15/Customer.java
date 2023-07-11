package ch15;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
		System.out.println("customer sell");
		
	}

	@Override
	public void buy() {
		System.out.println("customer buy");		
	}

	@Override
	public void order() {
		// TODO Auto-generated method stub
		System.out.println("customer order");
	}
	
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}

}
