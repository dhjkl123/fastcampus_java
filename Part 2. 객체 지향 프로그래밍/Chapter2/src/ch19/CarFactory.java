package ch19;

public class CarFactory {
	private static CarFactory instance = new CarFactory();
	private static int carNumber = 10000;
	private CarFactory() {};
	
	public static CarFactory getInstance() {
		return instance;
	}
	
	public Car createCar() {
		return new Car(++carNumber);
	}
}
