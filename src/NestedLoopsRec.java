import java.util.Scanner;

public class NestedLoopsRec {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int n = sc.nextInt();
		int []arr= new int[n];
		
		GenerateLoops(arr,0);
	}
	private static void GenerateLoops(int[]arr, int idx){
		int n = arr.length;
		if(idx==n){
			printArr(arr);
			return;
		}
		for(int i = 1; i<=n; i++){
			arr[idx]=i;
			GenerateLoops(arr,idx+1);
			
		}
		
		
	}
	private static void printArr(int[] arr){
		for(int a:arr){
			System.out.printf("%d ", a);
		}
		System.out.println();
	}

}
