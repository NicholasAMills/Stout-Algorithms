import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SearchAndSortAlgorithms implements SearchableAndSortable {

	
	//
	@Override
	public int sequentialSearch(ArrayList<Integer> A, int K) {
		// TODO Auto-generated method stub

		int index = 0;
		int last = A.size();
		while (index < last && A.get(index)!= K) {
			index++;
		}
		
		if (index < last) {
			return index;
		}
		else {
			return -1;
		}
	}

	@Override
	public int binarySearchRecursive(ArrayList<Integer> data, int value, int low, int high) {
		// TODO Auto-generated method stub
		if (high < low) {
			return -1;
			
		}
		int mid  = (low + high) / 2;
		
		//if the value at the mid value is less than the search value
		// search through the lower remaining values
		if (data.get(mid) > value) {
			return binarySearchRecursive(data, value, low, mid-1);
		}
		//if the value at the mid value of the search is greater than the search value
		//search through the remaining upper half
		else if (data.get(mid) < value) {
			return binarySearchRecursive(data, value, mid+1, high);
		}
		if (data.get(mid) == value) {
			return mid;
		}
		return -1;
	}

	@Override
	public int binarySearchIterative(ArrayList<Integer> data, int value) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = data.size()-1;
		while (low <= high) {
			int mid  = (low + high)/2;
			if (data.get(mid) > value) {
				high = mid - 1;
			}
			else if (data.get(mid) < value) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	@Override
	public void insertionSort(ArrayList<Integer> A) {
		// TODO Auto-generated method stub
		for (int i = 0; i < A.size(); i++) {
			int v = A.get(i);
			int j = i-1;
			
			//sets the value of one greater than the
			//position of j  to the value of j
			while (j >= 0 && A.get(j) > v) {
				A.set(j+1,A.get(j));
				
				j--;
			}
			A.set(j+1,v);
			
		}
	}

	@Override
	public void quickSort(ArrayList<Integer> A, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			/* pi is partitioning index, arr[pi] is now
			at right place */
			int pi = partition(A, low, high);
			
			quickSort(A, low, pi-1);
			quickSort(A, pi + 1, high);
		}

	}

	@Override
	public int partition(ArrayList<Integer> A, int left, int right) {
		// TODO Auto-generated method stub
		int p = A.get(left);
		int i = left;
		int j = right + 1;
		do {
			do {
				i++;
			} while (A.get(i) < p && i < right);
			do {
				j--;
			} while (A.get(j) > p && j > left);
			Collections.swap(A, i, j);
		} while (i < j);
		
		//undo last swap when i >= j
		Collections.swap(A, i, j);
		Collections.swap(A, left, j);
		
		return j;
	}

	@Override
	public void printArrayList(ArrayList<Integer> data) {
		// TODO Auto-generated method stub
		for(int i =0; i < data.size(); i ++) {
			System.out.print(data.get(i) + " ");
			if (i%100== 0 & i > 0) {
				System.out.println();
			}
		}

	}

}
