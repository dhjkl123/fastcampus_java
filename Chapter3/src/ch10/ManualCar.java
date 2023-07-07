package ch10;

public class ManualCar extends Car{

	@Override
	public void drive() {
		System.out.println("사람이 주행을 합니다.");
		System.out.println("사람이 핸들을 바꿉니다.");
	}

	@Override
	public void stop() {
		System.out.println("장애물 앞에서 차를 멈춥니다.");		
	}

}
