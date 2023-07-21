package july4;

import java.util.Iterator;

public class MatrixAddition {
	public static void rowsum(int[][] arr) {
		
		int colsize = arr[0].length;
		for (int i = 0; i < arr.length; i++) {
			int rowsum=0;
			for (int j = 0; j < colsize; j++) {
				rowsum += arr[i][j];
				
			}
			System.out.println("sum of"+(i+1)+"st row "+rowsum);
		}
		
		
	}
		
		public static void colsum(int[][] arr) {
			for (int i = 0; i < arr.length; i++) {
				  int colsum=0;
				for (int j = 0; j < arr[0].length; j++) {
					
					colsum += arr[j][i];
				}
				
				System.out.println("sum of "+(i+1)+"st column "+colsum);
			}
			
			
		}
		

	public static void main(String[] args) {
		int[][] num = {{2,5,7,9},
				{9,5,3,8},
				{1,5,8,3},
				{7,3,2,7}};
		
		rowsum(num);
		colsum(num);
		
		}

	}


