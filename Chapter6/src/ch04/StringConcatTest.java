package ch04;

public class StringConcatTest {

	public static void main(String[] args) {
		
		String s1 = "abcd";
		String s2 = "efg";
		
		StringConcatImpl strImpl = new StringConcatImpl();
		strImpl.makeString(s1,s2);
		
		
		StringConcat concat = (str1, str2) -> System.out.println(s1 + s2);
		concat.makeString(s1, s2);  
	}

}
