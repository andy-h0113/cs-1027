public class TestDataTypes {

	public static void main(String[] args) {
		int[] testArray = { 2, 4, 6 }; // This statement creates an array of size 3 storing values 2, 4, and 6
		DataTypes data1 = new DataTypes(2, 3.3, 's', true, new ClassA(3, testArray));
		DataTypes data2 = new DataTypes(2, 3.3, 's', true, new ClassA(3, testArray));

		// Test data1 == data2
		if (data1 == data2) {
			System.out.println("data1 == data2 || True");
		} else {
			System.out.println("data1 == data2 || False");
		}

		// Test data1.intVar == data2.intVar
		if (data1.intVar == data2.intVar) {
			System.out.println("data1.intVar == data2.intVar || True");
		} else {
			System.out.println("data1.intVar == data2.intVar || False");
		}

		// Test data1.charVar == data2.charVar
		if (data1.charVar == data2.charVar) {
			System.out.println("data1.charVar == data2.charVar || True");
		} else {
			System.out.println("data1.charVar == data2.charVar || False");
		}

		// Test data1.boolVar == data2.boolVar
		if (data1.boolVar == data2.boolVar) {
			System.out.println("data1.boolVar == data2.boolVar || True");
		} else {
			System.out.println("data1.boolVar == data2.boolVar || False");
		}

		// Test data1.doubleVar == dta2.doubleVar
		if (data1.doubleVar == data2.doubleVar) {
			System.out.println("data1.doubleVar == dta2.doubleVar || True");
		} else {
			System.out.println("data1.doubleVar == dta2.doubleVar || False");
		}

		// Test data1.varA == data2.varA
		if (data1.varA == data2.varA) {
			System.out.println("data1.varA == data2.varA || True");
		} else {
			System.out.println("data1.varA == data2.varA || False");
		}

		// Test data1.varA.numItems == data2.varA.numItems
		if (data1.varA.numItems == data2.varA.numItems) {
			System.out.println("data1.varA.numItems == data2.varA.numItems || True");
		} else {
			System.out.println("data1.varA.numItems == data2.varA.numItems || False");
		}

		// Test data1.varA.arrItems == data2.varA.arrItems
		if (data1.varA.arrItems == data2.varA.arrItems) {
			System.out.println("data1.varA.arrItems == data2.varA.arrItems || True");
		} else {
			System.out.println("data1.varA.arrItems == data2.varA.arrItems || False");
		}

	}

}
