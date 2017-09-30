import java.util.ArrayList;
import java.util.Scanner;

public class Permut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean []used= new boolean[n];
		int[] mp = new int[n];
//		for(int i = 0; i<n; i++){
//			used[i]=false;
//			
//		}
		permutate(0,n,mp, used);
	}

	private static void permutate(int i,int n, int[]mp, boolean []used) {
		if(i>=n){
			print(n,mp);
			return;
		}
		for(int k = 0; k<n; k++){
			if(used[k]== false){
				used[k]=true;
				mp[i]= k;
				permutate(i+1, n, mp, used);
				used[k]=false;
			}
		}
		
	}

	private static void print(int n, int[]mp) {
		for(int i =0; i<n; i++){
			System.out.print(mp[i]+1);
		}
		System.out.println();
		
	}



}
