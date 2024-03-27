/*
 * This class represents a player. Each player has a specific name, position, and jersey number
 * @author Andy Hwang | ihwang9 | 251217976
 */


public class Player {
	
	private String name;
	private String position;
	private int jerseyNum;
	
	public Player (String name, String position, int jerseyNum) {
		/*
		 * This is the constructor so we will be initializing the member variables here.
		 * @param name name of the player
		 * @param position position of the player
		 * @param jerseyNum jersey number of the player
		 */
		this.name = name;
		this.position = position;
		this.jerseyNum = jerseyNum;
	}
	// Getters
	/*
	 * Accessor method to get the name of the player
	 * @return name of the player	
	 */
	public String getName () {
		// Get player's name.
		return name;
	}
	
	public String getPosition() {
		return position;
	}
		
	public int getJerseyNum() {
		return jerseyNum;
	}
	
	
	// Setters
	/*
	 * Modifier method to set the name of the player
	 * @param name name of the player
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	public void setPosition (String position) {
		this.position = position;
	}
	
	public void setJerseyNum (int jerseyNum) {
		this.jerseyNum = jerseyNum;
	}
	
	
	// toString
	
	public String toString () {
		return this.name + ": #" + this.jerseyNum;
	}
	
	// Equals
	
	public boolean equals (Player other) {
		if (this.name.equals(other.name) && this.jerseyNum == other.jerseyNum) {
			return true;
		} else {
			return false;
		}
	}
}
