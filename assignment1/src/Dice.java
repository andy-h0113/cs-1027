/**
 * This class represents a dice. The dice holds one value at a time.
 * @author ihwang9 | 251217976
 */

public class Dice {
	
/**
 * Value held by the dice.
 */
	private int value;
	
/**
 * Constructor initializes the dice value
 */
	public Dice() {
		value = -1;
	}

/**
 * Constructor initializes the dice value with the given integer
 * @param num value of dice
 */
	public Dice(int num) {
		value = num;
	}
	
/**
 * Method simulates a dice roll and assigns a random number to the dice value
 */
	public void roll() {
		value = RandomNumber.getRandomNumber(1, 6);
	}
	
/**
 * Accessor method to get the value of the dice
 * @return value of the dice
 */
	public int getValue() {
		return value;
	}
}
