package ch16.game;

public class AdvancedLevel extends PlayerLevel{
	
	@Override
	protected void run() {
		System.out.println("빨리 달립니다.");
	}

	@Override
	protected void jump() {
		System.out.println("높이 jump 못하지롱");
	}

	@Override
	protected void turn() {
		System.out.println("turn 못하지롱");
		
	}

	@Override
	protected void showLevelMessage() {
		System.out.println("****** 중급자 레벨입니다 ******");
		
	}

}
