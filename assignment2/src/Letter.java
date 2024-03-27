/**
 * This class represents a Letter that will be part of a word and labels its participation
 * @author ihwang9 | 251217976
 *
 */

public class Letter {
	
	/**
	 * The letter held by object
	 */
	private char letter;
	
	/**
	 * Label that dictates whether the letter is used, unused, or correct
	 */
	private int label;
	
	/**
	 * Constant that shows that the Letter is unlabeled
	 **/
	private int UNSET = 1;
	
	/**
	 * Constant that shows that the Letter is unused
	 **/
	private int UNUSED = 2;
	
	/**
	 * Constant that shows that the Letter is used
	 **/
	private int USED = 3;
	
	/**
	 * Constant that shows that the Letter is correct
	 **/
	private int CORRECT = 4;
	
	/**
	 * Constructor initializes the letter with a character
	 * @param c character stored in object
	 */
	public Letter(char c) {
		label = UNSET;
		letter = c;
	}
	
	/**
	 * Method checks if two Letter objects are equal in content
	 * @param otherObject other Letter object
	 * @return true if they are equal and false if they are not equal
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Letter) {
			if (this.getLetter() == ((Letter) otherObject).getLetter()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Method returns a character to designate the label of the letter
	 * @return quotation based on label
	 */
	public String decorator() {
		if (label == USED) {
			return "+";
		} else if (label == UNUSED) {
			return "-";
		} else if (label == CORRECT) {
			return "!";
		} else {
			return " ";
		}
	}
	
	/**
	 * Method for string representation of each letter
	 * @return concatenated string in the form of ".C." where "." is the label quotation and C is content
	 */
	public String toString() {
		String labelType = this.decorator();
		return labelType + letter + labelType;
	}
	
	/**
	 * Method to re-assign a label to unused
	 */
	public void setUnused() {
		label = UNUSED;
	}
	
	/**
	 * Method to re-assign a label to used
	 */	
	public void setUsed() {
		label = USED;
	}

	/**
	 * Method to re-assign a label to correct
	 */
	public void setCorrect() {
		label = CORRECT;
	}
	
	/**
	 * Method to check if a letter is used in the word or not
	 * @return true if the letter unused and false if the letter is used
	 */
	public boolean isUnused() {
		if (label == UNUSED) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method takes a string and converts each letter in the string to a Letter object
	 * @param s string to be converted into an array of Letter objects
	 * @return word - an array of Letter objects
	 */
	public static Letter[] fromString(String s) {
		Letter[] word = new Letter[s.length()];
		for (int i=0; i < s.length(); i++) {
			Letter newLetter = new Letter(s.charAt(i));
			word[i] = newLetter;
		}
		return word;
	}
	
	// Getter method to access the letter of a Letter object
	private char getLetter() {
		return letter;
	}	 
}
