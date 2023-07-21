package july10;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class JavaChallenge6 {

	public static void main(String[] args) {
		String s = "pwwkew";
		Set<Character> set = new LinkedHashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
           set.add(s.charAt(i));
		}
		System.out.println("output:"+set);
		System.out.println("output:"+set.size());

	}

}
