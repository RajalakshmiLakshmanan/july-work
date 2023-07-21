package july10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Java Problem (12/20)

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
*/
public class JavaChallenge4 {
	public static boolean findoccur(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		boolean output = false;
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				Integer value = map.get(arr[i]);
				map.put(arr[i], value+1);
				
				
			}else {
				map.put(arr[i], 1);
			}
		}
		Set<Integer> set= new HashSet<Integer>();
		Set<Integer> dupset= new HashSet<Integer>();
		for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
			Integer value = entry.getValue();
			if(!set.add(value)) {
				dupset.add(value);	
			}	
		}
			
		if(dupset.isEmpty()) {
			output= true;
			
		}
		
		return output;
		
	}

	public static void main(String[] args) {
	  int[] input= {1,2};
      System.out.println("output:"+findoccur(input));
	}

}
