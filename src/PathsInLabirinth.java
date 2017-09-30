import java.util.ArrayList;
import java.util.Scanner;

public class PathsInLabirinth {
	static ArrayList<Character>path= new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int row = Integer.parseInt(sc.nextLine());
		int col = Integer.parseInt(sc.nextLine());
		
		boolean marked[][]=new boolean[row][col];
		char[][]lab= readLab(row,col,sc);
		findPath(0,0,'S',lab,marked);

	}
	private static char[][] readLab(int row,int col,Scanner sc) {
		char[][] lab= new char[row][col];
		
		for(int i = 0; i<row; i++){
			String b = sc.nextLine();
			char[]arr=b.toCharArray();
			for(int j = 0; j<arr.length; j++){
				
				lab[i][j]=arr[j];
			}
			
		}
		return lab;
	}
	private static void findPath(int row, int col, char direction,char[][] lab,boolean marked[][]) {
		if(!isInBound(row,col,lab))return;
		path.add(direction);
		if(isExit(row,col, lab)){
			printPath();
		}
		else if(!isVisited(row,col,marked)&&isFree(row,col,lab)){
			mark(row,col,marked);
			findPath(row,col+1,'R',lab,marked);
			findPath(row+1,col,'D',lab,marked);
			findPath(row,col-1,'L',lab,marked);
			findPath(row-1,col,'U',lab,marked);
			unmark(row,col,marked);
		}
		path.remove(path.size()-1);
		
	}
	private static void unmark(int row, int col,boolean marked[][]) {
		marked[row][col]=false;
		
	}
	private static void mark(int row, int col,boolean marked[][]) {
		marked[row][col]=true;
		
	}
	private static boolean isFree(int row, int col,char[][]lab) {
		
		return lab[row][col]=='-';
	}
	private static boolean isVisited(int row, int col,boolean marked[][]) {
		
		return marked[row][col]==true;
	}
	private static void printPath() {
		for(int i =1; i<path.size();i++){
			System.out.print(path.get(i));
		}
		System.out.println();
		
	}
	private static boolean isExit(int row, int col,char[][]lab) {
		return lab[row][col]=='e';
	}
	private static boolean isInBound(int row, int col,char[][]lab) {
		boolean res=true;
		if(row>=lab.length)res=false;
		if(col>=lab[0].length)res=false;
		if(row<0)res=false;
		if(col<0)res=false;
		return res ;
	}

}
