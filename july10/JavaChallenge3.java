package july10;

public class JavaChallenge3 {
	public static int[] twoSum(int[] numbers, int target)
	{
		int[] output  =new int[2];
     for (int i = 0; i < numbers.length; i+=2) {
    	 int sum= 0;
    	 sum = numbers[i] +numbers[i+1];
    	 if(sum == target) {
    		 output[0] = i;
    		 output[1]= i+1;
    		 
    	 }
		
	}
     return output;
     
	}

	public static void main(String[] args) {
        int[] num= {2,5,8,11};
        int target = 7;
     
         int[] result = twoSum(num,target);
         for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
         
	}

}
