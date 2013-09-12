package vClass;

public class Player {
	
	private String position;
	private int score;
	private String name;

	
	protected Player(){
		
	}
	
	public Player(String position, int score, String name) {
		super();
		this.position = position;
		this.score = score;
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
