/**
 * This class represents a word that is a part of the Wordle game
 * @author ihwang9 | 251217976
 */

public class Word {
	
	/**
	 * Node that points to the first node of the linked list containing the word
	 */
	private LinearNode<Letter> firstLetter;
	
	/**
	 * Constructor takes an array of Letter objects and appends them to a linked list
	 * @param letters an array of Letter objects representing a word
	 */
	public Word(Letter[] letters) {
		firstLetter = new LinearNode<Letter>();
		LinearNode<Letter> current = firstLetter;
		LinearNode<Letter> newNode;
		
		// Adds each letter object to the end of the linked list
		for(int i=0; i < letters.length; i++) {
			newNode = new LinearNode<Letter>(letters[i]);
			if (firstLetter.getElement() == null) {
				firstLetter.setElement(letters[i]);;
			} else {
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(newNode);
			}
		}
	}
	
	/**
	 * Method provides a string representation of the Word object
	 * @return string showing the labels of each Letter object in the word
	 */
	public String toString() {
		LinearNode<Letter> current = firstLetter;
		String stringRep = "Word:";
		while (current != null) {
			stringRep += (" " + current.getElement().toString());
			current = current.getNext();
		}
		return stringRep + " ";
	}
	
	/**
	 * Method that changes the label of each Letter in the Word based on a mystery word
	 * @param mystery the mystery word that the user is trying to figure out
	 * @return true if this word is identical to the mystery word and false if they are not
	 */
	public boolean labelWord(Word mystery) {
		boolean correctWord = true;
		boolean usedBool;
		LinearNode<Letter> currentMystery = mystery.getFirstLetter();
		LinearNode<Letter> currentThis = firstLetter;
		
		while (currentThis != null) {
		
			// Conditional for when the mystery word is shorter than the Word object
			if (currentMystery == null) {
				usedBool = checkUsed(currentThis, mystery);
				if (usedBool) {
					currentThis.getElement().setUsed();
					correctWord = false;
				} else {
					currentThis.getElement().setUnused();
					correctWord = false;
				}
				currentThis = currentThis.getNext();
			
			} else {
				// Checks if the word is Correct
				if (currentThis.getElement().equals(currentMystery.getElement())) {
					currentThis.getElement().setCorrect();
				} else {
					// Uses private method checkUsed
					usedBool = checkUsed(currentThis, mystery);
					if (usedBool) {
						currentThis.getElement().setUsed();
						correctWord = false;
					} else {
						currentThis.getElement().setUnused();
						correctWord = false;
					}
				}
				currentThis = currentThis.getNext();
				currentMystery = currentMystery.getNext();
			}
		}
		return correctWord;
	}
	
	/**
	 * Method to confirm whether a letter in the Word is used in the mystery word
	 * @param currentThis the current Letter being analyzed 
	 * @param the mystery word the Word is being compared to
	 * @return True if the letter is used in the mystery word and false if it is not used in the mystery word
	 */
	private boolean checkUsed(LinearNode<Letter> currentThis, Word mystery) {
		LinearNode<Letter> currentMystery = mystery.getFirstLetter();
		while (currentMystery != null) {
			if (currentThis.getElement().equals(currentMystery.getElement())) {
				return true;
			}
			currentMystery = currentMystery.getNext();
		}
		return false;
	}
	
	/**
	 * Helper method to access the linked list containing the word
	 * @return the reference to the first node of the linked list
	 */
	private LinearNode<Letter> getFirstLetter(){
		return firstLetter;
	}

}
