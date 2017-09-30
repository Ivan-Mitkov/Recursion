import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedAreasinaMatrix {

	private static final char VISITED = 'v';
	private static final char WALL ='*';
	static ArrayList<Area>array=new ArrayList<>();
	
	public class Area implements Comparable<Area>{
		public int row;
		public int col;
	
		private int size;
		public Area(int row,int col){
			this.row=row;
			this.col=col;
			this.size=0;
			
			
		}
		public  int resize(){
			return this.size++;
		}
		
		@Override
		public int compareTo(Area other) {
			if(other.size>this.size)return 1;
			else if(other.size==this.size)return 0;
			else return -1;
		}
		public void print(){
			System.out.printf(" at (%d, %d), size: %d\n",
					this.row,this.col,this.size);
		}
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int row = Integer.parseInt(sc.nextLine());
		int col = Integer.parseInt(sc.nextLine());
		
		char[][]conected= readLab(row,col,sc);
		//draw(conected);
		for(int i = 0; i<conected.length;i++){
			for(int j = 0; j<conected[0].length; j++){
				findConnected(conected,i,j);
			}
		}
		array.sort(null);
		System.out.printf("Total areas found: %d\n",array.size());
		for(int i = 0; i<array.size();i++){
			System.out.printf("Area #%d", i+1);
			array.get(i).print();
		}

	}
	public static void findConnected(char[][]arr, int row,int col){
		if(arr[row][col]==WALL||arr[row][col]==VISITED){			
			return;
		}
		ConnectedAreasinaMatrix a= new ConnectedAreasinaMatrix();
		Area area = a.new Area(row,col);
		CreateArea(row, col,arr,area);
		array.add(area);
		
	}
	private static void CreateArea(int row, int col,char[][]arr, Area area) {
		
		if(!isInBound(row,col,arr)
				||arr[row][col]==VISITED
				||arr[row][col]==WALL){
				return;
		}
		arr[row][col]=VISITED;
		area.resize();
		CreateArea(row+1,col,arr,area);		
		CreateArea(row,col+1,arr,area);		
		CreateArea(row-1,col,arr,area);		
		CreateArea(row,col-1,arr,area);
		
		
	}
	private static boolean isInBound(int row, int col, char[][] arr) {
		if(row<0)return false;
		if(row>=arr.length)return false;
		if(col<0)return false;
		if(col>=arr[0].length)return false;
		else{
			return true;
		}
		
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
	private static void draw(char[][] arr){
		for(int i = 0; i<arr.length;i++){
			for(int j = 0; j<arr[0].length;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}