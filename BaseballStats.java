package model;

/**
 * The BaseballStats class represents a single employee.
 * 
 * @author Richard Benjamin
 * @version 20151015
 *
 */


public class BaseballStats {

	private int playerId;
	private String lastName;
	private String firstName;
	private String Singles;
	private String Doubles;
	private String Triples;
	private String Homeruns;

	public BaseballStats() {
		playerId = 0;
		lastName = "";
		firstName = "";
		Singles = "";
		Doubles = "";
		Triples = "";     
		Homeruns = "";
	}

	public BaseballStats(int playerId, String lastName, String firstName, String Singles, String Doubles, String Triples, String Homeruns) {
		this.playerId = playerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.Singles = Singles;
		this.Doubles = Doubles;    
		this.Triples = Triples;
		this.Homeruns = Homeruns;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int hobbyId) {
		this.playerId = hobbyId;
	}

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSingles() {
		return Singles;
	}

	public void setSingles(String Singles) {
		this.Singles = Singles;
	}

	public String getDoubles() {
		return Doubles;
	}

	public void setDoubles(String doubles) {
		this.Doubles = doubles;
	}
	public String getTriples() {
		return Triples;
	}

	public void setTriples(String triples) {
		this.Triples = triples;
	}
	public String getHomeruns() {
		return Homeruns;
	}

	public void setHomeruns(String Homeruns) {
		this.Homeruns = Homeruns;
	}
	
	@Override
	public String toString() {
		return String.format("%7d : %s, %s, %s, %s,%s,%s\n", this.getPlayerId(), this.getLastName(),
				this.getFirstName(), this.getSingles(), this.getDoubles(), this.getTriples(),this.getHomeruns());
	}
}
