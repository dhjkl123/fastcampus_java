package ch14;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap() {
		hashMap = new HashMap<>();
	}
	
	public void addMember(Member member) {
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId) {
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
		}
		
		System.out.println("no element");
		return false;
	}
	
	public void showAllMember() {
		Iterator<Integer> iter = hashMap.keySet().iterator();
		
		while(iter.hasNext()) {
			int key = iter.next();
			Member member = hashMap.get(key);
			System.out.println(member);
		}
	}
}
