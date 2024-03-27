import java.util.Arrays;

/**
 * This class represents a Yahtzee roll and calculates the scores of the roll.
 * @author ihwang9 | 251217976
 */

public class Yahtzee {
	
/**
 * Array to hold the values of all five dice rolls
 */
	private Dice[] dice;
	
	/**
	 * Constructor adds 5 random numbers to the dice array
	 */
	public Yahtzee() {
		dice = new Dice[5];
		for (int i = 0; i < 5; i++) {
			dice[i] = new Dice();
			dice[i].roll();
		}
	}
	
	/**
	 * Constructor initializes the dice array with a decided dice roll
	 * @param filledDice results of a dice roll
	 */
	public Yahtzee(Dice[] filledDice) {
		dice = filledDice;
	}
	
	/**
	 * Method to determine the number of each integer in the dice roll
	 * @return count of each integer
	 */
	public int[] getValueCount() {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		
		// Loops through each value of the dice array and increments counters based on the value
		for (int i = 0; i < 5; i++) {
			if (dice[i].getValue() == 1) {
				count1++;
			} else if (dice[i].getValue() == 2) {
				count2++;
			} else if (dice[i].getValue() == 3) {
				count3++;
			} else if (dice[i].getValue() == 4) {
				count4++;
			} else if (dice[i].getValue() == 5) {
				count5++;
			} else {
				count6++;
			}
		}
		
		// Inserts all the counters into an integer array
		int[] valueCount = new int[] {count1, count2, count3, count4, count5, count6};
		return valueCount;	
	}
	
	/**
	 * Method determines all the possible scores for the dice roll
	 * @return options to score the dice roll
	 */
	public int[] getScoreOptions() {
		// Initializes each variable with the number of points based on the yahtzee scoring card
		int ace = this.getValueCount()[0] * 1;
		int two = this.getValueCount()[1] * 2;
		int three = this.getValueCount()[2] * 3;
		int four = this.getValueCount()[3] * 4;
		int five = this.getValueCount()[4] * 5;
		int six = this.getValueCount()[5] * 6;
		int triple = this.multipleKinds(3);
		int quadruple = this.multipleKinds(4);
		int fullHouse = this.fullHouse();
		int smallStraight = this.smallStraight();
		int largeStraight = this.largeStraight();
		int yahtzee = this.multipleKinds(5);
		int chance = dice[0].getValue() + dice[1].getValue() + dice[2].getValue() + dice[3].getValue() + dice[4].getValue();
		
		// Inserts all possible point scores into an integer array
		int[] scoreOptions = new int[] {ace, two, three, four, five, six, triple, quadruple, fullHouse, smallStraight, largeStraight, yahtzee, chance};
		return scoreOptions;
	}
	
	// Takes an integer as a parameter to determine to check for three of a kind, four of a kind, or yahtzee
	// Returns the numbers of points based on whether the dice array meets the requirements
	private int multipleKinds(int multiple) {
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			// Checks for three of a kind
			if ((this.getValueCount()[i] >= multiple) && multiple == 3) {
				sum = this.dice[0].getValue() + this.dice[1].getValue() + this.dice[2].getValue() + this.dice[3].getValue() + this.dice[4].getValue();
				return sum;
			
				// Checks for four of a kind
			} else if ((this.getValueCount()[i] >= multiple) && multiple == 4) {
				sum = this.dice[0].getValue() + this.dice[1].getValue() + this.dice[2].getValue() + this.dice[3].getValue() + this.dice[4].getValue();
				return sum;
			
				//Checks for Yahtzee
			} else if (this.getValueCount()[i] == multiple && multiple == 5){
				return 50;
			}
		}
		return 0;
	}
	

	// Returns 25 points if there is a full house and 0 if there isn't
	private int fullHouse() {
		boolean tripleCheck = false;
		boolean doubleCheck = false;
		for (int i = 0; i < 6; i++) {
			if (this.getValueCount()[i] == 3) {
				tripleCheck = true;
			} 
			if (this.getValueCount()[i] == 2) {
				doubleCheck = true;
			}
		}
		if (tripleCheck && doubleCheck) {
			return 25;
		} else {
			return 0;
		}
	}
	
	
	// Returns 30 points if there is a small straight and 0 if there isn't
	private int smallStraight() {
		int numDuplicates = 0;
		int counter = 0;
		// Copies the dice array to a new variable to sort it
		int[] copyDice = new int[5];
		for (int i = 0; i < 5; i++) {
			copyDice[i] = this.dice[i].getValue();
		}
		Arrays.sort(copyDice);
		
		// Uses getValueCount method to remove possibilities of multiple duplicates causing errors
		for (int i = 0; i < 6; i++) {
			if (this.getValueCount()[i] > 2) {
				return 0;
			} else if (this.getValueCount()[i] == 2) {
				numDuplicates++;
			}
		}
		if (numDuplicates > 1) {
			return 0;
		}
		
		// Loops through the dice array to confirm whether or not there is a small straight
		for (int i = 1; i < 5; i++) {
			if (copyDice[i-1] == copyDice[i]) {
				continue;
			} else if (copyDice[i-1] == (copyDice[i] - 1)) {
				counter++;
			} else {
				counter = 0;
			}
		}
		if (counter == 3) {
			return 30;
		} else {
			return 0;
		}
	}
	
	// Returns 50 points if there is a large straight and 0 points if there isn't
	private int largeStraight() {
		// copies the dice array to a new variable to sort it
		int[] copyDice = new int[5];
		for (int i = 0; i < 5; i++) {
			copyDice[i] = this.dice[i].getValue();
		}
		Arrays.sort(copyDice);
		
		// checks whether there are any duplicates using the getValueCount method
		for (int i = 0; i < 6; i++) {
			if (this.getValueCount()[i] > 1) {
				return 0;
			}
		}
		// Checks whether the dice array contains a large straight
		for (int i = 1; i < 5; i++) {
			if (copyDice[i-1] == (copyDice[i] - 1)) {
				continue;
			} else {
				return 0;
			}
		}
		return 40;
	}
	
	/**
	 * Method determines the highest score and its scoring method based on all the scoring options
	 * @return the highest score and its index value
	 */
	public int[] score() {
		int[] score = this.getScoreOptions();
		int highest = 0;
		int index = 0;
		for (int i = 0; i < 13; i++) {
			if (score[i] > highest) {
				highest = score[i];
				index = i;
			}
		}
		int[] maxScore = new int[] {highest, index};
		return maxScore;
	}
	
	/**
	 * Method checks if two dice rolls are equal
	 * @param other other given dice roll
	 * @return true if they are equal and false if they are not equal
	 */
	public boolean equals(Yahtzee other) {
		for (int i = 0; i < 6; i++) {
			if (this.getValueCount()[i] == other.getValueCount()[i]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method represents the dice roll as a string
	 * @return dice roll as a string
	 */
	public String toString() {
		return "Dice: {" + this.dice[0].getValue() + ", " + this.dice[1].getValue() + ", "  + this.dice[2].getValue() + ", "  + this.dice[3].getValue() + ", "  + this.dice[4].getValue() + "}";
	}
	
}






























