package ch14;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	public void take(int money) {
		this.money += money;
		passengerCount += 1;
	}
	
	public void showinfo() {
		System.out.println(busNumber + "의 승객 수는 " + passengerCount + ", 수익은" + money + "원 입니다.");
	}
}
