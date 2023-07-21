package july4;
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


public class JavaChallenge3 {

	public static void main(String[] args) {

         String a="amazon";
         char[] charArray = a.toCharArray();
        int l=  charArray.length;
         String b= "azonam";
         char temp='\0';
         for (int i = 0; i <=1; i++) {
        	 
			charArray[l-2]= charArray[i];
			charArray[i]=temp;
            l++;
		}
         String string = charArray.toString();
         System.out.println(string);
         for (int i = 0; i < charArray.length; i++) {
        	 System.out.print(charArray[i]);
			
		}
         
          
	}

}
