package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ1926 {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n,m;
	static int[][] arr;
	static boolean[][] check;
	static int cnt=0;
	static int max_val = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		
		n = Integer.parseInt(tem[0]);
		m = Integer.parseInt(tem[1]);
		arr = new int[n][m];
		check = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			tem = in.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				bfs(i,j);
			}
		}
		
		System.out.println(cnt);
		System.out.println(max_val);
	}

	private static void bfs(int i, int j) {
		if(check[i][j] || arr[i][j]==0) return;
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {i,j});
		check[i][j] = true;
		cnt += 1;
		int area = 1;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = dr[d] + temp[0];
				int nc = dc[d] + temp[1];
				
				if(nr<0 || nc<0 || nr>=n || nc>=m || check[nr][nc] || arr[nr][nc]==0) continue;
				
				queue.offer(new int[] {nr,nc});
				area+=1;
				check[nr][nc] = true;
				
			}

		}
		if(max_val < area ) max_val = area;
	}
}






