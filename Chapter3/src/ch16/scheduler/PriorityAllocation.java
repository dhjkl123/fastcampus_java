package ch16.scheduler;

public class PriorityAllocation implements Scheduler{

	@Override
	public void sendCallToAgent() {
		System.out.println("고객의 등급에 따라 등급이 높은 고객은 업무능력이 우수한 상담원에게 배분합니다.");		
	}

}
