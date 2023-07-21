package july10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JavaChallenge2 {
	public static String findMaxdupString(String a) {
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		List<Character> list = new ArrayList<Character>();
		int count =0;
		String output;
		char dup= '\0';
		for (int i = 0; i < a.length(); i++) {
			if(map.containsKey(a.charAt(i))){
				Integer value = map.get(a.charAt(i));
				map.put(a.charAt(i), value+1);
				
			}else {
				map.put(a.charAt(i), 1);
					
				}
			}
		System.out.println(map);
			for(Map.Entry<Character, Integer> entrySet: map.entrySet()) {
				if(entrySet.getValue()>=count) {
					dup = entrySet.getKey();
					//list.add(dup);
					count= entrySet.getValue();
				}
				
				//System.out.println(count);
				
				
				//System.out.println(dup);
				
		}
		output = Character.toString(dup);
			//String string = list.toString();
		//return string;
		return output;
		
	}

	public static void main(String[] args) {
		String a="hjjkkhk";
		System.out.println("output:"+findMaxdupString(a));
	}

}
