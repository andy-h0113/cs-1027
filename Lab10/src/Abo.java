
public class Abo {
	public static int rabo(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n % 2 == 0) {
			return 1 + rabo(n/2);
		}
		if (n % 2 == 1) {
			return 2 + rabo((n+1)/2);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(rabo(i));
		}
	}

}
