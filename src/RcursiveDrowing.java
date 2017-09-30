import java.util.Scanner;

public class RcursiveDrowing {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char figure = '*';
		char second = '#';
		PrintFigure(n,figure,second);

	}
	private static void PrintFigure(int n, char first, char second){
		if(n<=0)return;
		else{
			for(int i = 0; i<n; i++){
				System.out.print(first);
			}
			System.out.println();			
			PrintFigure(n-1, first, second);
			for(int i = 0; i<n; i++){
				System.out.print(second);
			}
			System.out.println();
		}
	}
	

}
