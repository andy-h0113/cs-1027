
public class Ball {
	
	private String colour;
	private double r1, r2, r3;
	private double x, y, z;
	private String name;
	private double elasticity;
	
	public Ball (String colour, double r1, double r2, double r3, double x, double y, double z, String name, double elasticity) {
		this.colour = colour;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.x = x;
		this.y = y; 
		this.z = z;
		this.name = name;
		this.elasticity = elasticity;
	}
	
	public Ball () {
		this.colour = "black";
		this.r1 = 5.0;
		this.r2 = 5.0;
		this.r3 = 5.0;
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
		this.name = "Generic ball";
		this.elasticity = 1.0;
	}
	
	public Ball (String colour, double elasticity) {
		this.colour = colour;
		this.r1 = 5.0;
		this.r2 = 5.0;
		this.r3 = 5.0;
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
		this.name = "Generic ball";
		this.elasticity = elasticity;
	}
	
	// Getters
	
	public String getColour () {
		return colour;
	}
	
	public double getR1 () {
		return r1;
	}
	
	public double getR2 () {
		return r2;
	}
	
	public double getR3 () {
		return r3;
	}
	
	public double getElasticity () {
		return elasticity;
	}
	
	
	// Setters
	
	public void setColour (String colour) {
		this.colour = colour;
	}
	
	public void setR1 (double r1) {
		this.r1 = r1;
	}
	
	public void setR2 (double r2) {
		this.r2 = r2;
	}
	
	public void setR1 (double r3) {
		this.r3 = r3;
	}
	
	public void setPosition (double[] pos) {
		// Assume that pos has 3 elements in order x, y, z
		x = pos[0];
		y = pos[1];
		z = pos[2];
	}
	
	
	// toString
	
	public String toString () {
		return this.getColour() + " " + this.getR1() + ",(" + this.x + " , " + this.y + " , " + this.z +").";
	}
	
	
	// equals
	
	public boolean equals (Ball other) {
		if (this.colour.equals(other.getColour()) && this.getR1() == other.getR1()) {
			return true;
		} else {
			return false;
		}
	}
}
