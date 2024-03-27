
public class ReversibleArray<T> {
	private T[] array;
	private int count;
	
	public ReversibleArray (T[] array) {
		this.array = array;
		count = array.length;
	}
	
	public String toString() {
		String string = "";
		for (int i = 0; i < count; i++) {
			string += (array[i]);
			if ((i + 1) != count) {
				string += (", ");
			}
		}
		return string;
	}
	
	public void reverse() {
		T temp;
		for (int i = 0; i < count / 2; i++) {
			temp = array[i];
			array[i] = array[array.length - (i+1)];
			array[array.length - (i+1)] = temp;
		}
	}
}
