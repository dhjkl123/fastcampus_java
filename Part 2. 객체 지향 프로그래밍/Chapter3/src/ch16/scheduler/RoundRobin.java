package ch16.scheduler;

public class RoundRobin implements Scheduler {

	@Override
	public void sendCallToAgent() {
		System.out.println("다음 순서의 상담원에게 배분 합니다.");
	}

}
