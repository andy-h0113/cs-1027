
public class TestHarness {
	
	public static void main (String[] args) {
		/*
		Ball b1 = new Ball();
		
		Ball b2 = new Ball("orange", 12.3);
		
		Ball b3 = new Ball("purple", 7.5, 7.5, 7.5, 1.0, 2.4, -2.7, "Western ball", 9.8);
		
		Ball b4 = new Ball("orange", 12.3);
		
		b1.setColour("dark blue");
		System.out.println(b1.getColour());
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		
		
		if (b4.equals(b2)) {
			System.out.println("Same ball");
		} else {
			System.out.println("Different ball");
		}
		*/
		
		Ball b1 = new Ball();
		Ball b2 = new RoundBall(12.7);
		RoundBall b3 = new RoundBall (9.5); // roundball to ball is not legal
		
		// From Ball Class
		System.out.println(b1.getElasticity());
		System.out.println(b2.getElasticity());
		System.out.println(b3.getElasticity());

		// From RoundBall Class
		//System.out.println(b1.calcSurfaceArea()); || Not a roundBall so cannot call methods from roundball || Cannot cast type ball into roundball type
		System.out.println(((RoundBall)b2).calcSurfaceArea());
		System.out.println(b3.calcSurfaceArea());
	}

}
