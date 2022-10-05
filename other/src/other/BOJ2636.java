package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2636 {
	
	static int[][] arr;
	static int r,c,time;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		
		r = Integer.parseInt(tem[0]);
		c = Integer.parseInt(tem[1]);
		arr = new int[r][c];
		
		for(int i=0; i<r; i++) {
			tem = in.readLine().split(" ");
			for(int j=0; j<c; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
			}
		}
		
		for(int i =1; i<r-1; i++) {
			for(int j=1; j<c-1; j++) {
								
				bfs(i, j);
			}
		}
		
		
		
		
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {i,j});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			i = temp[0];
			j = temp[1];
			
			for(int l=0; l<4; l++) {
				int nnr = i + dr[l];
				int nnc = j + dc[l];
				if(nnr<0 || nnc<0 || nnr>=r || nnc>=c) continue;
				if(arr[nnr][nnc]==0) arr[i][j]=0;
			}
			
			for(int d=0; d<4; d++) {
				int nr = i + dr[d];
				int nc = j + dc[d];
				
				if(nr<=0 || nc<=0 || nr>=r-1 || nc>=c-1) continue;
				queue.offer(new int[] {nr,nc});

			}
			
		}
		
		
	}
	
}











