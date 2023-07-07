package ch08;

public class Order {
	public String orderNumber;
	public String phoneNumber;
	public String addres;
	public String orderDate;
	public String orderTime;
	public int orderPayment;
	public String muneNumber;
	
	public Order(String orderNumber, String phoneNumber, String addres, String orderDate, String orderTime, int orderPayment, String muneNumber)
	{
		this.orderNumber = orderNumber;
		this.phoneNumber = phoneNumber;
		this.addres = addres;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderPayment = orderPayment;
		this.muneNumber = muneNumber;
		
	}
	
	public void showOrder()
	{
		System.out.println("주문 접수 번호: " + orderNumber);
		System.out.println("주문 핸드폰 번호: " + phoneNumber);
		System.out.println("주문 집 주소: " + addres);
		System.out.println("주문 날짜: " + orderDate);
		System.out.println("주문 시간: " + orderTime);
		System.out.println("주문 가격: " + orderPayment);
		System.out.println("메뉴 번호: " + muneNumber);
	}
}
