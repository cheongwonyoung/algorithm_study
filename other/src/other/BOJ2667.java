package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BOJ2667 {
	static int[][] arr;
	static int n;
	static boolean[][] check;
	// 상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(in.readLine());
		List<Integer> list = new ArrayList<Integer>();
		arr = new int[n][n];
		check = new boolean[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] temp = in.readLine().split("");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1 && !check[i][j]) {
					list.add(bfs(i, j));
				}
			}
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int temp : list) {
			sb.append(temp).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int bfs(int i, int j) {
		int cnt = 1;
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[]{i,j});
		arr[i][j] = 0;
		
		while(!queue.isEmpty()) {
			 int[] temp = queue.poll();
			 int r = temp[0];
			 int c = temp[1];
			 
			 for(int d=0; d<4; d++) {
				 int nr = r + dr[d];
				 int nc = c + dc[d];
				 
				 if(nr<0 || nc<0 || nr>=n || nc>=n) continue;
				 
				 if(arr[nr][nc]==1 && !check[nr][nc]) {
					 check[nr][nc] = true;
					 queue.offer(new int[]{nr,nc});
					 cnt++;
				 }
				 
			 }
			 
			 
			 
		}
		
		return cnt;
	}
	
}




