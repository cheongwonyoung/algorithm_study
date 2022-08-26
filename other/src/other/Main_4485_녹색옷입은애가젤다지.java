package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_4485_녹색옷입은애가젤다지 {
	static int n;
	static int[][] arr;
	static int[][] val;	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<Integer>();
		int cnt = 1;
		while(true) {
			n = Integer.parseInt(in.readLine()); 
			if(n==0) {
				break;
			}
			
			arr = new int[n][n];
			val = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String[] tem = in.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(tem[j]);
					val[i][j] = Integer.MAX_VALUE;
					
				}
			}
			
			bfs();
			sb.append("Problem ").append(cnt++).append(": ").append(val[n-1][n-1]).append("\n");
			
			
		}
		System.out.println(sb);
	}
	public static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0});
		val[0][0] = arr[0][0];
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int row = temp[0];
			int col = temp[1];

			for(int i =0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr <0 || nr >=n || nc<0 || nc>=n) continue;
				if(val[nr][nc] <= val[row][col] + arr[nr][nc]) continue;
				
					val[nr][nc] = val[row][col] + arr[nr][nc];
					queue.add(new int[] {nr, nc});
					
				
			}
			
			
		}
		
		
	}
	
	
		
	
		
		
	
}
