package ch04;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
//		Customer customer1 = new Customer();
//		customer1.setCustomerName("이순신");
//		customer1.setCustomerId(10010);
//		customer1.bonusPoint = 1000;
//		System.out.println(customer1.showCustomerInfo());
		
//		VIPCustomer customer2 = new VIPCustomer();
//		customer2.setCustomerName("김유신");
//		customer2.setCustomerId(10020);
//		customer2.bonusPoint = 10000;
//		System.out.println(customer2.showCustomerInfo());
		
		Customer customer = new Customer(10010, "이순신");
		customer.bonusPoint = 1000;
		int price = customer.calcPrice(1000);
		System.out.println(customer.showCustomerInfo() + price);
		
		Customer vc = new VIPCustomer(123345,"noname");
		
		
		VIPCustomer customer2 = new VIPCustomer(10020, "김유신");
		customer2.bonusPoint = 10000;
		price = customer2.calcPrice(1000);
		System.out.println(customer.showCustomerInfo() + price);
		
		Customer customer3  = new VIPCustomer(12345,"noname");
		System.out.println(customer3.calcPrice(1000));

		
	}

}
