package ch19;

public class CoffeTest {

	public static void main(String[] args) {
		Coffee etiopiaCoffee = new EtiopiaAmericano();
		etiopiaCoffee.brewing();
		
		Coffee etiopiaLatter = new Latte(etiopiaCoffee);
		etiopiaLatter.brewing();
		
		Coffee mochaEtiopia = new Mocha(new Latte(new EtiopiaAmericano()));
		mochaEtiopia.brewing();
	}

}
