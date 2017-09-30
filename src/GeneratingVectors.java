import java.util.ArrayList;
import java.util.Scanner;

public class GeneratingVectors {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] vector= new int[n];
		Gen01( vector, 0);

	}
private static void Gen01(int[] vector, int index){
	if(index>vector.length-1){
		print(vector);
		return;
	}
	for(int i = 0; i<=1; i++){
		vector[index]=i;
		Gen01(vector, index+1);
	}
}
private static void print(int[] vector) {
	for(int i = 0; i<vector.length; i++){
		System.out.print(vector[i]);
	}
	System.out.println();
}
}
