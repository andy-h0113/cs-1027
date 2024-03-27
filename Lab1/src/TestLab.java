
public class TestLab {

	public static void main(String[] args) {
		Player p1 = new Player("Andy", "Offence", 42);
		
		System.out.println(p1.getName());
		System.out.println(p1.getPosition());
		System.out.println(p1.getJerseyNum());
		
		p1.setName("Hwang");
		p1.setPosition("Defence");
		p1.setJerseyNum(7);
		
		System.out.println(p1.getName());
		System.out.println(p1.getPosition());
		System.out.println(p1.getJerseyNum());
		
		System.out.println(p1);
		
		Player p2 = new Player("Hwang", "Defence", 7);
		
		if (p1.equals(p2)) {
			 System.out.println("Same player");
		} else {
			System.out.println("Different player");
		}

	}

}
