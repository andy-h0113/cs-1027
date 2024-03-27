
public class RoundBall extends Ball{
	
	public RoundBall (double radius) {
		super("black", radius, radius, radius, 0.0, 0.0, 0.0, "round ball", 4.5);
	}
	
	public double getRadius () {
		return super.getR1();
	}
	
	public double calcSurfaceArea () {
		return 4.0 * Math.PI * getR1()*getR1();
	}
	
	
	
}
