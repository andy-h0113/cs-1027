
public class Person implements Comparable<Person> {
	
	/* Attribute declarations */
	private String name;
	private String city;
	private String email;
			
	/**
	 * Constructor initializes the person's name and email address
	 */
	public Person(String name, String email, String city) {
		this.name = name;
		this.email = email;
		this.city = city;
	}

	/**
	 * toString to display the person's info in a clean format
	 * return String of the person's info
	 */
	public String toString() {
		String s = String.format("%10s\t\t%30s\t\t%10s", name, email, city);
		return s;
	}



    // Write your classes here
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCity() {
		return city;
	}
	
	private int compareByName(Person other) {
		int comparison = name.compareTo(other.getName());
		if (comparison == 0) {
			return 0;
		} else if (comparison < 0) {
			return -1;
		} else {
			return 1;
		}
	}
	
	private int compareByEmail(Person other) {
		int comparison = email.compareTo(other.getEmail());
		if (comparison == 0) {
			return 0;
		} else if (comparison < 0) {
			return -1;
		} else {
			return 1;
		}
	}
	
	private int compareByCity(Person other) {
		int comparison = city.compareTo(other.getCity());	
		if (comparison == 0) {
			return 0;
		} else if (comparison < 0) {
			return -1;
		} else {
			return 1;
		}
	}


	/**
	 * compareTo determines the order of the contacts
	 */
	public int compareTo(Person other) {
        // Write your code here     
		int comparison;
		if (ContactList.sortBy == 'n') {
			comparison = this.compareByName(other);
		} else if (ContactList.sortBy == 'e') {
			comparison = this.compareByEmail(other);
		} else {
			comparison = this.compareByCity(other);
		}
		return comparison;
	}

}