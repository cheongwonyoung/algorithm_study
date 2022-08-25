package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_7576_토마토 {
	
	static int[][] day;
	static int[][] arr;
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n, m;
	static int result;
	static int max_val = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		List<int[]> list = new ArrayList<>();
		
		m = Integer.parseInt(tem[0]);
		n = Integer.parseInt(tem[1]);
		arr = new int[n][m];
		day = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				day[i][j] = -10;
			}
		}
		for(int i=0; i<n; i++) {
			tem = in.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
				if(arr[i][j]==-1) day[i][j] = -1;
				if(arr[i][j]==1) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		bfs(list);
//		for (int k = 0; k < n; k++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(day[k][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < m; j++) {
				if(day[k][j] == -10) result = -1;
				if(day[k][j] > max_val) max_val = day[k][j];
			}
		
		}
		if(result==0) System.out.println(max_val);
		else System.out.println(result);
		
		
	}
	
	public static void bfs(List<int[]> l) {
		Queue<Integer[]> queue = new ArrayDeque<Integer[]>();
		int len = l.size();
		for(int i=0; i<len; i++) {
			int r =l.get(i)[0];
			int c =l.get(i)[1];
			Integer[] tem2 = {r,c};
			queue.add(tem2);
			day[r][c] = 0;
		}
		
		while(!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			int row = cur[0];
			int col = cur[1];
			
			for(int i=0; i<4; i++) {
				Integer[] tem = new Integer[2];
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr<0 || nr>=n || nc<0 || nc>=m || arr[nr][nc]==-1 || arr[nr][nc]==1) continue;
				arr[nr][nc] = 1;
				tem[0] = nr;
				tem[1] = nc;

				day[nr][nc] = day[row][col] + 1;
				queue.offer(tem);
				

			}
		}
		
		
	}
	
}










