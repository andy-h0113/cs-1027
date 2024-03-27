/**
 * This class is the main repository for the wordle game, storing the mystery word and all previous guesses
 * @author ihwang9 | 251217976
 */

public class WordLL {
	
	/**
	 * Word object that stores the mystery word
	 */
	private Word mysteryWord;
	
	/**
	 * Head of linked list that will contain all previous Word guesses
	 */
	private LinearNode<Word> history;
	
	/**
	 * Constructor initializes the mystery word and the linked list
	 * @param mystery the mystery word to be guessed
	 */
	public WordLL(Word mystery) {
		mysteryWord = mystery;
		history = new LinearNode<Word>();
	}
	
	/**
	 * Method checks if the guess is correct and stores the guess in the history linked list
	 * @param guess Word object that user guesses
	 * @return true if the guess is correct and false if the guess is not correct
	 */
	public boolean tryWord (Word guess) {
		// Checks if the guess is correct
		boolean correctWord = guess.labelWord(mysteryWord);
		
		// Stores the guess in history
		LinearNode<Word> newNode = new LinearNode<Word>(guess);
		if (history.getElement() == null) {
			history.setElement(guess);
		} else {
			newNode.setNext(history);
			history = newNode;
		}
		return correctWord;
	}
	
	/**
	 * Method prints all previous guesses in order of newest to oldest
	 * @return string containing a string representation of all previous guesses
	 */
	public String toString() {
		String stringRep = "";
		LinearNode<Word> current = history;
		while (current != null) {
			stringRep += (current.getElement().toString() + "\n");
			current = current.getNext();
		}
		return stringRep;
	}
}
