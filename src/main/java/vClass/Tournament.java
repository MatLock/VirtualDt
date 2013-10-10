package vClass;

import java.util.List;

public class Tournament {
	
	private int id_tournament;
	private long id;
	private List<MatchDate> fixture;
	
	protected Tournament(){
		
	}
	
	public Tournament(List<MatchDate> fixture, int id_tournament) {
		this.fixture = fixture;
		this.id_tournament = id_tournament;
	}

	public int getId_tournament() {
		return id_tournament;
	}

	public void setId_tournament(int id_tournament) {
		this.id_tournament = id_tournament;
	}

	
	public List<MatchDate> getFixture() {
		return fixture;
	}

	public void setFixture(List<MatchDate> fixture) {
		this.fixture = fixture;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
