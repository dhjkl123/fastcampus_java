package ch16.scheduler;

public interface Scheduler {
	default void getNextCall(){
		System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다.");
	};
	public void sendCallToAgent();
}
