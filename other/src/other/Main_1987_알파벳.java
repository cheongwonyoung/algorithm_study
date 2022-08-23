package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1987_알파벳 {
<<<<<<< HEAD
=======
	static int r,c,len = 0;
	//	상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[] check = new boolean[26]; 
	static char[][] arr;
>>>>>>> 16e6365bf397baeaf8bae84fbd50ef60bb9101dd
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
<<<<<<< HEAD
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
		
=======
		r = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		
		arr = new char[r][c];
		
		for(int i=0; i<r; i++) {
			String tem = in.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = tem.charAt(j);
			}
		}
		
		check[arr[0][0]-65] = true;
		
		dfs(0, 0, 1);
		System.out.println(len);
	}

	private static void dfs(int i, int j, int k) {
		
		for(int l = 0; l<4; l++) {
			int nr = i + dr[l];
			int nc = j + dc[l];
			
			// 범위 넘어가나 체크
			if(nr <0 || nr >= r || nc < 0 || nc >=c) continue;
			
			// 방문했던 알파벳일때 이전에 간 구간이 긴지 현재가 긴지 비교
			if(check[arr[nr][nc]-65]) {
				len = Math.max(len, k);
				continue;
			}
			
			check[arr[nr][nc]-65] = true;
			dfs(nr, nc, k+1);
			check[arr[nr][nc]-65] = false;
			
			
		}
>>>>>>> 16e6365bf397baeaf8bae84fbd50ef60bb9101dd
		
		
	}
	
}
