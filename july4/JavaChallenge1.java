package july4;
//You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
//
//Return the sum of all the unique elements of nums.
//
//Example 1:
//
//Input: nums = [1,2,3,2]
//Output: 4
//Explanation: The unique elements are [1,3], and the sum is 4.
//Example 2:
//
//Input: nums = [1,1,1,1,1]
//Output: 0
//Explanation: There are no unique elements, and the sum is 0.
//Example 3:
//
//Input: nums = [1,2,3,4,5]
//Output: 15
//Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.

import java.util.HashSet;
import java.util.Set;

public class JavaChallenge1 {
	public static int uniqueSum(int[] arr) {
		Set<Integer> set  = new HashSet<Integer>();
		Set<Integer> dupset  = new HashSet<Integer>();
		int sum= 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(!set.add(arr[i])) {
				dupset.add(arr[i]);
				
			}	
			
		}
		
		set.removeAll(dupset);
		int size = set.size();
		if(size >= 1) {
			for(Integer num:set) {
				sum= sum+ num;
				
			}
			
			
		}
		
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,2,4};
		int[] arr2= {1,1,1,1,1};
		System.out.println("output:" +uniqueSum(arr2));

	}

}
