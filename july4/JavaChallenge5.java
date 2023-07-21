package july4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JavaChallenge5 {
public static int[] mergeArray(int[] arr1,int[] arr2) {
	Set<Integer> set = new HashSet<Integer>();
	
	for (int i = 0; i <arr1.length; i++) {
		set.add(arr1[i]);
		
	}
	for (int i = 0; i < arr2.length; i++) {
		set.add(arr2[i]);
		
	}
	List<Integer> list = new ArrayList<Integer>(set);
	Collections.sort(list);
	int[] output = new int[list.size()];
	
	for (int i = 0; i < output.length; i++) {
		output[i] = list.get(i);
		
	}
	
	return output;
}
	public static void main(String[] args) {
      int[] arr1  = {3,5,8,3,9,4};
      int[] arr2 = {7,9,2,5,6};
      
      int[] res = mergeArray(arr1,arr2);
      
      for (int i = 0; i < res.length; i++) {
		System.out.println(res[i]);
	}


	}

}
