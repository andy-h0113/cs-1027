
public class Card implements Comparable<Card>{
	
	private String suit; // Spades, Hearts, Diamonds, or Clubs
	private String rank; // Ace, 2, 3, ..., 10, Jack, Qeen), or Kng

	public Card (String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit () {
		return suit;
	}
	
	public String getRank () {
		return rank;
	}
	
	public void setSuit (String suit) {
		this.suit = suit;
	}
	
	public void setRank (String rank) {
		this.rank = rank;
	}
	
	public String toString () {
		return rank + " of " + suit;
	}

	@Override
	public int compareTo(Card o) {
		if (this.equals(o)) {
			return 0;
		} else if (this.getRankValue() == o.getRankValue()) {
			if (this.getSuitValue() < o.getSuitValue()) {
				return -1;
			} else {
				return 1;
			}
		} else if (this.getRankValue() < o.getRankValue()) {
			return -1;
		} else {
			return 1;
		}
	}

	private boolean equals(Card other) {
		if ((this.getRankValue() == other.getRankValue()) && this.getSuitValue() == other.getSuitValue()) {
			return true;
		} else {
			return false;
		}
	}
	
	private int getSuitValue() {
		int suitValue;
		if (this.suit.equals("Diamonds")) {
			suitValue = 1;
		} else if (this.suit.equals("Clubs")) {
			suitValue = 2;
		} else if (this.suit.equals("Hearts")) {
			suitValue = 3;
		} else {
			suitValue = 4;
		}
		return suitValue;
	}
	
	private int getRankValue() {
		int rankValue;
		if (this.rank.equals("1")) {
			rankValue = 1;
		} else if (this.rank.equals("2")) {
			rankValue = 2;
		} else if (this.rank.equals("3")) {
			rankValue = 3;
		} else if (this.rank.equals("4")) {
			rankValue = 4;
		} else if (this.rank.equals("5")) {
			rankValue = 5;
		} else if (this.rank.equals("6")) {
			rankValue = 6;
		} else if (this.rank.equals("7")) {
			rankValue = 7;
		} else if (this.rank.equals("8")) {
			rankValue = 8;
		} else if (this.rank.equals("9")) {
			rankValue = 9;
		} else if (this.rank.equals("10")) {
			rankValue = 10;
		} else if (this.rank.equals("Jack")) {
			rankValue = 11;
		} else if (this.rank.equals("Queen")) {
			rankValue = 11;
		} else if (this.rank.equals("King")) {
			rankValue = 11;
		} else {
			rankValue = 12;
		}
		return rankValue;
	}
}
