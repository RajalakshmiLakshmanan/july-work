package july4;

public class JavaChallenge4 {
	public static String removeChar(String s, char c) {
		String replace = s.replace(c, '\0');
		String replaceAll = replace.replaceAll("[^a-z]", "");
		return replaceAll;
		
	}

	public static void main(String[] args) {
	String s ="aaa";
	char c='a';
	System.out.println("output:"+removeChar(s,c));
     
	}

}
