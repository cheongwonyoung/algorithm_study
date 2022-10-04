package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ1012 {
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] check;
	static int[][] arr;
	static int n,m,k,total;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t<=T; t++) {
			total = 0;
			String[] tem = in.readLine().split(" ");
			m = Integer.parseInt(tem[0]);
			n = Integer.parseInt(tem[1]);
			k = Integer.parseInt(tem[2]);
			
			arr = new int[n][m];
			
			
			for(int i = 0; i<k; i++) {
				tem = in.readLine().split(" ");
				int temp1 = Integer.parseInt(tem[0]);
				int temp2 = Integer.parseInt(tem[1]);

				arr[temp2][temp1] = 1;
			}
			check = new boolean[n][m];
			for(int i = 0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(check[i][j] || arr[i][j]==0) continue;
					bfs(i,j);
				}
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
		
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j});
		check[i][j] = true;
		
		while(!queue.isEmpty()) {

			int[] temp = queue.poll();
			i = temp[0];
			j = temp[1];
			
			for(int r = 0; r<4; r++) {
				int nr = i + dr[r];
				int nc = j + dc[r];
				
				if(nr<0 || nc<0 || nr>=n || nc>=m || check[nr][nc] ||arr[nr][nc]==0) continue;
				
				queue.offer(new int[] {nr,nc});	
				check[nr][nc]=true;
			}
			
		}
		total++;
		
	}
}
