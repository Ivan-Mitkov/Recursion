import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int b = sc.nextInt();
		
		int pp=Fact(b);
		System.out.println(pp);
	}
	private static int Fact(int start){
		
		if(start ==1)return 1;
		else return start*Fact(start-1);
		
	}

}
