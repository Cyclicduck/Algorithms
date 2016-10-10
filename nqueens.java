import java.util.*;

public class nqueens {

	public static void main(String[] args){
		
		boolean[][] board = new boolean[8][8];
		
		dfs(board, 0);
		
	}
	
	public static void dfs(boolean[][] board, int num){
	
		if(num == 8){
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(board[i][j]){System.out.print("1" + " ");}
					if(!board[i][j]){System.out.print("0" + " ");}					
				}
				System.out.println();
			}
			System.exit(0);
		}
			for(int i = 0; i < 8; i++){
				if(!att(board, num, i)){
					board[num][i] = true;
					dfs(board, num+1);
					board[num][i] = false;
				}
			}
		
		
	}
	
	public static boolean att(boolean[][] board, int a, int b){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if(board[i][j]){
					if(i == a || j == b || i-j == a-b || i+j == a+b){return true;}
				}
				
			}
			
		}
		return false;
	}
}
