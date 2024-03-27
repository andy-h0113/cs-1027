
public class ClassC {

	public static int counter = 0;

	public ClassC() {
		counter += 1;
	}

	public void incCounter() {
		++counter;
	}

	public int getCounter() {
		return counter;
	}

}
