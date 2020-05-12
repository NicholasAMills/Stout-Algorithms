
import java.util.ArrayList;
import java.util.Random;



public class SearchAndSortDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creates a random value for the ten values in the list
		
		int n = 100;
		Random random = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n ; i++ ) {
			
			list.add(random.nextInt(n*10));
		}
		
		
		//this prints out the list before the list is sorted
		System.out.println(list.toString());
		
		
		SearchAndSortAlgorithms search = new SearchAndSortAlgorithms();
		list.set(0, 0);
		list.set(list.size()-1, 10000000);
		
		//sorts the list using quickSort
		search.quickSort(list, 0, list.size()-1);
		
		//spacing of lines between lists
		System.out.print("\n\n\n");
		
		//prints out the list after it is sorted
		System.out.println(list.toString());
		
		
		//testing the binary iterative search
		/*
		// this is searching for the value 0 in the arrayList
		if(search.binarySearchIterative(list, 0) != -1) {
			System.out.print("you found it");
		}
		else {
			//if the value 0 is not found
			System.out.print("it was not found");
		}
		
		//iterative search looking for the highest value
		if(search.binarySearchIterative(list, 10000000) != -1) {
			System.out.print("you found it");
		}
		else {
			//if the value is not found
			System.out.print("it was not found");
		}
		*/
		
		//this test the bound if the value is not found in the list
		if(search.binarySearchRecursive(list, -1, 0, list.size() - 1) != -1) {
			System.out.print("you found it");
		}
		else {
			System.out.print("it was not found");
		}
		
		//this is testing the upper bound or largest value in the array list
		if(search.binarySearchRecursive(list, 10000000, 0, list.size() - 1) != -1) {
			System.out.print("you found it");
		}
		else {
			System.out.print("it was not found");
		}
		
		
		//test sequential search looking for the value of 16
		if(search.sequentialSearch(list, 16) != -1) {
			System.out.print("you found it");
		}
		else {
			System.out.print("it was not found");
		}
	
	}

}

