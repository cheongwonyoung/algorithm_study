package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_2636_치즈 {
		static int r,c,cheese,pre,time;
		static int[][] arr;
		static boolean[][] check;
		static int[] dr = {-1,1,0,0};
		static int[] dc = {0,0,-1,1};
		static List<int[]> list;
		
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] tem = in.readLine().split(" ");
		r = Integer.parseInt(tem[0]);
		c = Integer.parseInt(tem[1]);
		arr = new int[r][c];
		
		for(int i=0; i<r; i++) {
			tem = in.readLine().split(" ");
			for(int j=0; j<c; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
				if(arr[i][j]==1) cheese++;
				
			}
		}
		
		while(cheese>0) {
			
			pre = cheese;
			bfs(0,0);
			time++;
			for(int[] temp : list) {
				arr[temp[0]][temp[1]] = 0;
				cheese--;
			}
			
			
		}
		sb.append(time).append("\n").append(pre).append("\n");
		System.out.println(sb);

	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		check = new boolean[r][c];
		queue.offer(new int[] {i,j});
		check[i][j] = true;
		list = new ArrayList<>();
		
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			i = temp[0];
			j = temp[1];
			
			for(int d = 0; d<4; d++) {
				int nr = i + dr[d];
				int nc = j + dc[d];
				
				if(nr<0 || nc<0 || nr>=r || nc>=c || check[nr][nc]) continue;
				if(arr[nr][nc]==1) {
					list.add(new int[] {nr,nc});
					check[nr][nc]=true;
					continue;
					
				}
				
				queue.offer(new int[] {nr,nc});
				check[nr][nc]=true;
				
			}
			
			
		}
		
		
	}

	
}











