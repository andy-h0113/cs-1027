/**
 * This class expands the possibilities of the traditional Wordle game
 * @author ihwang9 | 251217976
 */

public class ExtendedLetter extends Letter {

	/**
	 * Variable to hold the content of the object
	 */
	private String content;
	
	/**
	 * integer to designate the family of the object
	 */
	private int family;
	
	/**
	 * boolean to indicate whether two ExtendedLetter objects are related
	 */
	private boolean related;
	
	/**
	 * constant to default value for family
	 */
	private int SINGLETON = -1;
	
	/**
	 * Constructor to initialize the superclass and content with a string
	 * @param s string to be initialized to content
	 */
	public ExtendedLetter(String s) {
		super('a');
		
		content = s;
		related = false;
		family = SINGLETON;
	}
	
	/**
	 * Constructor to initialize the superclass, content with a string, and family with an integer
	 * @param s string to be initialized to content
	 * @param fam integer to be initialized to family
	 */
	public ExtendedLetter(String s, int fam) {
		super('a');
		
		content = s;
		related = false;
		family = fam;
	}
	
	/**
	 * Method to check if the contents of two objects are equal
	 * @return true if they contain the same info and false if they do not
	 */
	public boolean equals(Object other) {
		if (other instanceof ExtendedLetter) {
			if (this.getFamily() == (((ExtendedLetter) other).getFamily())) {
				related = true;
			}
			if (this.getContent().equals(((ExtendedLetter) other).getContent())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method provides a string representation of the ExtendedLetter object
	 * @return string that depicts the ExtendedLetter and its use
	 */
	public String toString() {
		if ((this.decorator() == "-") && (related == true)) {
			return "." + this.content + ".";
		} else {
			return super.decorator() + this.content + super.decorator();
		}
	}
	
	/**
	 * Method to add objects of ExtendedLetter to an array based on a string array and an integer array
	 * @param content string array to be added to the letters array
	 * @param codes integer array to be added to the letters array
	 * @return an array of Letter objects
	 */
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length];
		
		for (int i=0; i < codes.length; i++) {
			if (codes[i] == 0) {
				letters[i] = new ExtendedLetter(content[i]);
			} else {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		
		return letters;
	}
	
	/**
	 * Helper method to access the family variable
	 * @return the family variable
	 */
	private int getFamily() {
		return family;
	}
	
	/**
	 * Helper method to access the content in the object
	 * @return the content variable
	 */
	private String getContent() {
		return content;
	}
}
