package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1987_알파벳 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int r = Integer.parseInt(temp[0]);
		int c = Integer.parseInt(temp[1]);
		int cnt = 1;
		
		// 상하좌우
		int[] dr = { -1, 1, 0, 0}; 
		int[] dc = { 0, 0, -1, 1}; 
		
		boolean[][] visit = new boolean[r][c]; // 방문했는지
		boolean[] use = new boolean[c]; // 알파벳 사용 여부
		int[][] arr = new int[r][c];
		
		
		
		for (int i = 0; i < r; i++) {
			temp = in.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		
		
	}
	
}
