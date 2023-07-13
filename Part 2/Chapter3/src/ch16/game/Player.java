package ch16.game;

public class Player {
	public int level;
	private PlayerLevel playerlevel;
	
	public Player() {
		playerlevel = new BeginnerLevel();
	}
	
	public int getLevel() {
		return level;
	}
	
	public void upgradeLevel(PlayerLevel playerlevel) {
		this.playerlevel = playerlevel;
	}
	
	public void play(int count) {
		playerlevel.go(count);
	}
	
}
