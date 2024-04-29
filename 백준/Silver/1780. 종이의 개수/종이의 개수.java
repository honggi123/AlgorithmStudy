import java.util.Scanner;
 
public class Main {
 
	public static int[][] board;
	public static int GRAY = 0;	
	public static int WHITE = 0;
	public static int BLACK = 0;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		board = new int[N][N];
 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = in.nextInt();
			}
		}
 
		partition(0, 0, N);
 
		System.out.println(GRAY);	
		System.out.println(WHITE);	
		System.out.println(BLACK);	
 
	}
 
	
	public static void partition(int row, int col, int size) {
         if(colorCheck(row, col, size)){
	        if(board[row][col] == -1) { 
				GRAY++;
			}
			else if(board[row][col] == 0) {
				WHITE++;
			}
			else {
				BLACK++;
			}             
            return;
         }
         int newSize = size / 3;
         partition(row, col, newSize);
         partition(row, col+newSize, newSize);
         partition(row, col+newSize*2, newSize);

         partition(row+newSize, col, newSize);
         partition(row+newSize, col+newSize, newSize);
         partition(row+newSize, col+newSize*2, newSize);

         partition(row+newSize*2, col, newSize);
         partition(row+newSize*2, col+newSize, newSize);
         partition(row+newSize*2, col+newSize*2, newSize);

	}
 
	public static boolean colorCheck(int row, int col, int size) {
        int firstColor = board[row][col];
		for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(board[i][j] != firstColor){
                    return false;
                }
            }
        }
        return true;
	}
 
}