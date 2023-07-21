package july4;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//A distinct string is a string that is present only once in an array.
//
//Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".
//
//Note that the strings are considered in the order in which they appear in the array.
//
//
//
//Example 1:
//
//Input: arr = ["d","b","c","b","c","a"], k = 2
//Output: "a"
//Explanation:
//The only distinct strings in arr are "d" and "a".
//"d" appears 1st, so it is the 1st distinct string.
//"a" appears 2nd, so it is the 2nd distinct string.
//Since k == 2, "a" is returned. 
//Example 2:
//
//Input: arr = ["aaa","aa","a"], k = 1
//Output: "aaa"
//Explanation:
//All strings in arr are distinct, so the 1st string "aaa" is returned.


public class JavaChallenge2 {
	public static String findKthUniqueStr(String[] str,int k) {
		Set<String> set = new LinkedHashSet<String>();
		Set<String> dupset = new LinkedHashSet<String>();
		
		for (int i = 0; i < str.length; i++) {
			
			if(!set.add(str[i])) {
				dupset.add(str[i]);
			}
			
		}
		set.removeAll(dupset);
		List<String> list = new LinkedList<String>(set);
		return list.get(k-1);
		
		
	}

	public static void main(String[] args) {
		String[] input= {"aaa","aa","a"};
		int k=3;
		
		System.out.println("output:"+findKthUniqueStr(input,k));
	}

}
