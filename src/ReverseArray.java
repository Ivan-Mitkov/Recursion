import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] b = sc.nextLine().split(" ");
		int[] arr =new int[b.length];
		for(int i = 0; i<b.length; i++){
			arr[i]=Integer.parseInt(b[i]);
			
		}

		ReverseArr(arr, 0, arr.length-1);
		for(int a:arr){
			System.out.printf("%d ", a);
		}
	}
	
	private static void ReverseArr(int [] arr, int start, int end){
		if(start>=end)return;
		else{
			int startElem= arr[start];
			int endElem = arr[end];
			arr[start]=endElem;
			arr[end]=startElem;		
			
			ReverseArr(arr, start+1, end-1);
			
		}
		
	}

}
