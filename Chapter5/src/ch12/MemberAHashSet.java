package ch12;

import java.util.HashSet;
import java.util.Iterator;

public class MemberAHashSet {
	private HashSet<Member> hashSet;
	
	public MemberAHashSet() {
		hashSet = new HashSet<>();
	}
	
	public MemberAHashSet(int size) {
		hashSet = new HashSet<>(size);
	}
	
	public void addMember(Member member) {
		hashSet.add(member);
	}
	
	public boolean removeMember(int memberId) {
//		for(int i = 0; i < arrayList.size(); i++) {
//			Member member = arrayList.get(i);
//			
//			int tempId = member.getMemberId();
//			if(tempId == memberId) {
//				arrayList.remove(i);
//				return true;
//			}
//		}
//		
//		System.out.println(memberId + "가 존재하지 않습니다.");
//		return false;
		
		Iterator<Member> iter = hashSet.iterator();
		
		while(iter.hasNext()) {
			Member member = iter.next();
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				hashSet.remove(member);
				return true;
			}
			
			
			}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(var member : hashSet) {
			System.out.println(member);
		}
		System.out.println();
	}
}
