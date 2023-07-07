package ch08;

public class ClassTest {

	public static void main(String[] args) {
		Human Tomas = new Human(180,78,37,"Tomas",true);
		
		Order order = new Order("202011020003", "01023450001","서울시 강남구 역삼동 111-333", "20201102", "130258", 35000, "0003");
		order.showOrder();
		
	}

}
