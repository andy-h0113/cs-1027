public class ClassA {
	private final int SIZE_ARRAY = 5;
	public int numItems;
	public int[] arrItems;

	public ClassA(int n, int[] arr) {
		numItems = n;
		arrItems = arr;
	}

	public ClassA() {
		numItems = 0;
		arrItems = new int[SIZE_ARRAY];
	}
	
	public boolean equals (ClassA otherClass) {
		if (this.numItems == otherClass.numItems) {
			for (int i=0; i <this.arrItems.length; i++) {
				if (this.arrItems[i] == otherClass.arrItems[i]) {
					continue;
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
		
	}
	
}


/*
1) this and other have same value in numItems
2a) both arrItems are null
2b) both store the same values that are in the same order in the first numItems entries
*/