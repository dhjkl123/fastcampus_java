package ch22;

class Bank{
	private int money = 10000;
	
	public synchronized void saveMoney(int save) {
		int m = getMoney();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setMoney(m+save);
	}
	
	public  void minusMoney(int minus) {
		synchronized(this) {
			int m = getMoney();
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			setMoney(m-minus);
		}

	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}

class Park extends Thread{
	public void run() {
		System.out.println("start save");
		SycnMain.bank.saveMoney(3000);
		System.out.println("save money : " + SycnMain.bank.getMoney());
	}
}

class ParkWife extends Thread{
	public void run() {
		System.out.println("start minus");
		SycnMain.bank.minusMoney(1000);
		System.out.println("minus money : " + SycnMain.bank.getMoney());
	}
}

public class SycnMain {
	public static Bank bank = new Bank();

	public static void main(String[] args) {
		
		ParkWife pw = new ParkWife();
		pw.start();

		try {
			Thread.sleep(200);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Park p = new Park();
		p.start();
		
	}

}
