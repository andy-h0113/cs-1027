public class DataTypes {
	public int intVar;
	public double doubleVar;
	public char charVar;
	public boolean boolVar;
	public ClassA varA;

	public DataTypes() {
	}

	public DataTypes(int newIntVar, double newDoubleVar, char newCharVar, boolean newBoolVar, ClassA newVarA) {
		intVar = newIntVar;
		doubleVar = newDoubleVar;
		charVar = newCharVar;
		boolVar = newBoolVar;
		varA = newVarA;
	}
	
	public boolean equals (DataTypes otherType) {
		if (this.intVar == otherType.intVar && this.doubleVar == otherType.doubleVar && this.charVar == otherType.charVar && this.boolVar == otherType.boolVar && this.varA.equals(otherType.varA)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
