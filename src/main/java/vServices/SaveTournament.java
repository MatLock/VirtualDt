package vServices;

import java.util.List;

import vClass.ClassDAO;
import vClass.MatchDate;
import vClass.Operation;
import vClass.Tournament;

public class SaveTournament implements Operation<Tournament>{
	
	private List<MatchDate> fixture;
	private int id_tournament;

	public SaveTournament(List<MatchDate> fixture, int id){
		this.fixture = fixture;
		this.id_tournament = id;
	}

	public Tournament execute() {
		Tournament t = new Tournament(fixture,id_tournament); 
		new ClassDAO<Tournament>(Tournament.class).save(t);
		return null;
	}

}
