import java.util.ArrayList;
import java.util.Scanner;

public class ArraySum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		String[] b = sc.nextLine().split(" ");
		for(String c:b){
			arr.add(Integer.parseInt(c));
			
		}
		int pp=Sum(arr, 0);
		System.out.println(pp);
	}
	private static int Sum(ArrayList<Integer>a,int  index){
		
		if(a.size()-1==index)return a.get(index);
		else return a.get(index)+Sum(a,index+1);
		
	}
}
