import java.util.Scanner;

public class CombinationWithRepetition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] arr= new int[n];
		for(int i = 0; i<n; i++){
			arr[i]=i+1;
		}
		 CombinationRepetition(arr, n, m);
	}
	// Program to print all combination of size r in an array
	// of size n with repetitions allowed
	
	/* arr[]  ---> Input Array
	  chosen[] ---> Temporary array to store indices of
	                current combination
	   start & end ---> Staring and Ending indexes in arr[]
	   r ---> Size of a combination to be printed */
	private static void CombinationRepetitionUtil(int chosen[], int arr[],
	                    int index, int r, int start, int end)
	{
	    // Since index has become r, current combination is
	    // ready to be printed, print
	    if (index == r)
	    {
	        for (int i = 0; i < r; i++)
	            System.out.printf("%d ", arr[chosen[i]]);
	        System.out.println();
	        return;
	    }
	 
	    // One by one choose all elements (without considering
	    // the fact whether element is already chosen or not)
	    // and recur
	    for (int i = start; i <= end; i++)
	    {
	        chosen[index] = i;
	        CombinationRepetitionUtil(chosen, arr, index + 1,
	                                               r, i, end);
	    }
	    return;
	}
	 
	// The main function that prints all combinations of size r
	// in arr[] of size n with repitions. This function mainly
	// uses CombinationRepetitionUtil()
	private static void CombinationRepetition(int arr[], int n, int r)
	{
	    // Allocate memory
	    int chosen[]= new int[r+1];
	 
	    // Call the recursice function
	    CombinationRepetitionUtil(chosen, arr, 0, r, 0, n-1);
	}
	 
	// Driver program to test above functions
	
}
