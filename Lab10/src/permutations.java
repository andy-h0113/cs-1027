
import java.util.*;

public class permutations {
	
	public static void permutations(String prefix, String suffix) {
		if (suffix == "") {
			System.out.println(prefix);
		}
		for (int i = 0; i < suffix.length(); i++) {
			char c = suffix.charAt(i);
			String suff = removeChar(suffix, i);
			String pre = prefix + c;
			permutations(pre, suff);
		}
	}
	
	private static String removeChar(String s, int i) {
		 return s.substring(0, i) + s.substring(i+1, s.length());
		}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter a string: ");  
		String s = sc.nextLine();
		
		permutations("", s);
	}
}
