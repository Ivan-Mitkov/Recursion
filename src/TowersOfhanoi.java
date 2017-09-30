import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class TowersOfhanoi {

	private static int stepsTaken=0;
	static Stack<Integer>source= new Stack<Integer>();	
	static Stack<Integer>destination= new Stack<Integer>();
	static Stack<Integer>spare= new Stack<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =n; i>0;i--){
			source.push(i);
		}
		printRodes();
		moveDisk(n,source,destination, spare);
		//printRodes();
		sc.close();
	}
	private static void moveDisk(int bottomDisk,
			Stack<Integer>source,Stack<Integer>destination,Stack<Integer>spare ){
		if(bottomDisk==1){
			stepsTaken++;
			destination.push(source.pop());
			System.out.printf("Step #%d: Moved disk\n",stepsTaken);
			printRodes();
			return;
		}
		else{
			moveDisk(bottomDisk-1, source,spare, destination);
			stepsTaken++;
			destination.push(source.pop());
			System.out.printf("Step #%d: Moved disk\n",stepsTaken);
			printRodes();
			moveDisk(bottomDisk-1, spare,destination,source );
		}
		

	}
	private static void printRodes(){
		System.out.print("Source: ");
		System.out.println(printStack(source));
		System.out.print("Destination: ");
		System.out.println(printStack(destination));
		System.out.print("Spare: ");
		System.out.println(printStack(spare));
		System.out.println();
	}
	private static String printStack(Stack<Integer>source){
		Iterator<Integer> iter = source.iterator();
		String res="";
		if(source.isEmpty())return "";
		else{
			while(iter.hasNext()){
				
					res+=iter.next()+", ";
			}
		}
		res=res.substring(0, res.length()-2);
		return res;
	}
	
}
