package ch07;

import java.util.ArrayList;
import java.util.Arrays;

public class TravelTest {

	public static void main(String[] args) {
		
		Customer CustomerLee = new Customer();
		CustomerLee.setCustomerAge(40);
		CustomerLee.setCustomerPay(100);
		CustomerLee.setCustomerName("Lee");
		
		Customer CustomerKim = new Customer();
		CustomerKim.setCustomerAge(20);
		CustomerKim.setCustomerPay(100);
		CustomerKim.setCustomerName("Kim");
		
		Customer CustomerHong = new Customer();
		CustomerHong.setCustomerAge(13);
		CustomerHong.setCustomerPay(50);
		CustomerHong.setCustomerName("Hong");
		
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(CustomerLee);
		customers.add(CustomerKim);
		customers.add(CustomerHong);
		
		System.out.println("=== 고객 명단 ===");
		customers.stream().forEach(c->System.out.println(c.getCustomerName()));
		System.out.println("=== 총액 ===");
		System.out.println(customers.stream().mapToInt(c->c.getCustomerPay()).sum());
		System.out.println("=== 20세 이상 고객 ===");
		customers.stream().filter(c->c.getCustomerAge() >= 20).forEach(c->System.out.println(c.getCustomerName()));
				
	}

}
