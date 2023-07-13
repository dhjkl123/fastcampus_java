package ch16.game;

public class BeginnerLevel extends PlayerLevel{

	@Override
	protected void run() {
		System.out.println("천천히 달립니다.");
	}

	@Override
	protected void jump() {
		System.out.println("jump 못하지롱");
	}

	@Override
	protected void turn() {
		System.out.println("turn 못하지롱");
		
	}

	@Override
	protected void showLevelMessage() {
		System.out.println("****** 초급자 레벨입니다 ******");
		
	}

}
