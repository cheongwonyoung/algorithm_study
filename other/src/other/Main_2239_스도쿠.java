package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_2239_스도쿠 {

	static int[][] arr = new int[9][9];
	static boolean[][] rowCheck = new boolean[9][9];
	static boolean[][] colCheck = new boolean[9][9];
	static boolean[][] rangeCheck = new boolean[9][9];
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<9; i++) {
			String[] temp = in.readLine().split("");
			for(int j =0; j<9; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if(arr[i][j] != 0) {
					rowCheck[i][arr[i][j]-1] = true;
					colCheck[j][arr[i][j]-1] = true;
					rangeCheck[3*(i/3)+j/3][arr[i][j]-1] = true;
				}
			}
		}
		
		dfs(0,0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	
	static void dfs(int r, int c) {
		
		if(r==9 && c==0) {
			check = true;
			
			return;
		}
		
		if(arr[r][c]!=0) {
			if(c<8) {
				dfs(r,c+1);
			}
			else {
				dfs(r+1,0);
			}
			if(check) return;
		}
		else {
			for(int i=1; i<=9; i++) {
				
				if(!rowCheck[r][i-1] && !colCheck[c][i-1] && !rangeCheck[3*(r/3)+c/3][i-1]) { // 들어갈 수 있으면
					arr[r][c] = i;
					rowCheck[r][i-1] = true;
					colCheck[c][i-1] = true;
					rangeCheck[3*(r/3)+c/3][i-1] = true;
					if(c<8) {
						dfs(r,c+1);
					}
					else {
						dfs(r+1,0);
					}
					if(check) 
						return;
					arr[r][c]=0;
					rowCheck[r][i-1] = false;
					colCheck[c][i-1] = false;
					rangeCheck[3*(r/3)+c/3][i-1] = false;
				}
			}
		}
		
	}
	
	
}
