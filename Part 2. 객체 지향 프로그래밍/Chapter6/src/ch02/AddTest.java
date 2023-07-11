package ch02;

public class AddTest {

	public static void main(String[] args) {
		
		Add addL = (x, y) -> {return x+y;}; // 람다 기본형
		
		Print print = str->{System.out.println(str);}; //매개변수가 하나일 때 괄호 생략 가능
		
		/*
		
 		x, y -> {System.out.println(x+y);};  // 매개 변수 두 개 이상인 경우 괄호 생략 불가 (오류)
		
		str-> System.out.println(str); // 실행문이 한 문장인 경우 중괄호 생략 가능
		str-> return str.length();  // return 포함시 중괄고 생략 불가 (오류)
		
		(x, y) -> x+y; // 실행문이 한 문장의 반환문인 경우엔 return과 중괄호를 모두 생략
		
		*/
		
		System.out.println(addL.add(2, 3));
	}

}
