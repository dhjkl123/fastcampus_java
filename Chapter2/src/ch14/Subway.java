package ch14;

public class Subway {
	int lineNumber;
	int passengerCount;
	int money;
	
	public Subway(int lineNumber){
		this.lineNumber = lineNumber;
	}
	
	public void take(int money) {
		this.money += money;
		passengerCount +=1;
	}
	
	public void showinfo() {
		System.out.println(lineNumber + "의 승객 수는 " + passengerCount + ", 수익은" + money + "원 입니다.");
	}

}
