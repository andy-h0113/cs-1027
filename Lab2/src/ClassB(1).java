
public class ClassB {

	private int counter = 0;

	public ClassB() {
		counter = 1;
	}

	public void incCounter() {
		++counter;
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {
		int i;
		ClassB a = new ClassB();
		i = a.counter;
		a.incCounter();
		System.out.println("i = " + i + " counter = " + a.counter);
	}

}
