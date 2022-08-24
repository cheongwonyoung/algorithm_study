package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2206 {
		// 상하좌우
		static int[] dr = {-1, 1, 0, 0};
		static int[] dc = {0, 0, -1, 1};
		static int n,m,cnt = 1;

		static boolean[][] visit;
		
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		visit = new boolean[n][m];
		int[][] arr = new int[n][m];
		
		
		for(int i=0; i<n; i++) {
			temp = in.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		
		
		
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[] tem = {r,c};
		queue.add(tem);
		visit[r][c] = true;
		
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i =0; i <4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr <0 || nr>=n || nc<0 || nc>=m) {
					continue;
				}
				
				visit[nr][nc] = true;
				bfs(nr, nc);
				visit[nr][nc] = false;
				
			}
		}
		
	}
	
	
	
}
