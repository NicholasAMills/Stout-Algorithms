package default_package;
import java.util.Random;


public class SearchAndSortDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creates a random value for the ten values in the list
		
		int n = 10;
		Random random = new Random();
		int[] list = new int[n];
		for(int i = 0; i < n ; i++ ) {
			list[i]= random.nextInt(n*10);
		}
		
		for(int i = 0; i < list.length; i ++) {
			System.out.println(list[i]);
			
		}
		
		SearchAndSortAlgorithms search = new SearchAndSortAlgorithms();
		
		
	}

}

