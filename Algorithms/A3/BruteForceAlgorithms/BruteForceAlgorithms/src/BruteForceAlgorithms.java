import java.awt.Point;

/**
 * 
 */

/**
 * @author masont
 *
 */
public class BruteForceAlgorithms implements BruteForcible {

	@Override
	/**
	 * ALGORITHM SelectionSort(A[0..n-1])
	 * Sorts a given array A by selection sort
	 * Input: An array of A[0..n-1] of orderable elements
	 * Output: Array A[0..n-1] sorted in ascending order
	 * for i = 0 to n-2 do
	 * 	min = i;
	 *  for j=i+1 to n-1 do
	 *  	if A[j] < A[min]    min = j
	 *  swap A[i] and A[min]
	 *
	 * @param A - Array of orderable elements
	 */
	public void selectionSort(int[] A) {
		int min = 0;
		//for i = 0 to n-2 do
		for(int i = 0; i<= A.length-2; i++) {
			 	min = i; //min = i;
			 	//for j=i+1 to n-1 do
			 	for (int j=i+1; j <= A.length-1; j++) {
			 		//if A[j] < A[min]    min = j
			 		if (A[j] < A[min]   ) 
			 				min = j;
			 	}
			 	//swap A[i] and A[min]
			 	int temp = A[i];
			 	A[i] = A[min];
			 	A[min] = temp;
		}
	}

	@Override
	public int sequentialSearch(int[] A, int K) {
		// TODO Implement SequentialSearch Algorithm in Programming Assignment
		return 0;
	}

	@Override
	public int bruteForceStringMatch(String T, String P) {
		// TODO Implement BruteForceStringMatch Algorithm in Programming Assignment
		return 0;
	}

	@Override
	public Point[] bruteForceClosestPoints(Point[] P) {
		// TODO Implement BruteForceClosestPoints Algorithm in Programming Assignment
		int index1=0, index2=0;
		
		
		//use index1 and index2 to make an array of two points to return
		Point[] closest = new Point[2];
		closest[0] = P[index1];
		closest[1] = P[index2];
		return closest;
	}
	
	public void printArray(int[] data) {
		for(int i=1; i<= data.length; i++) {
			System.out.printf("%,9d" , data[i-1] );
			//System.out.printf(Locale.US, "%,d %n", 10000);
			if(i%20 == 0 && i > 0)
				System.out.println();
		}
	}
}
