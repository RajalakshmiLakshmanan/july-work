package july10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
//
//Example 1:
//
//Input:
//a = amazon
//b = azonam
//Output: 1
//Explanation: amazon can be rotated anti
//clockwise by two places, which will make
//it as azonam.

public class JavaChallenge1 {
	public static int rotateString(String a,String b) {
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < a.length(); i++) {
			list.add(a.charAt(i));
			
		}
		Collections.rotate(list, -2);//Anticlockwise rotate 
		//Collections.rotate(list, 2);---clockwise rotation
		System.out.println(list);
		StringBuilder build  =new StringBuilder();
		for(Character c:list) {
			build.append(c);
			
		}
		String rotatedstr = build.toString();
		System.out.println(rotatedstr);
		if(b.equals(rotatedstr)) {
			return 1;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		String a = "amazon";
			String b = "azonam";
			System.out.println("output:"+rotateString(a,b));
		
	}

}
