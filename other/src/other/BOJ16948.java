package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ16948 {
	
	static int dr[] = {-2, -2, 0, 0, 2, 2};
	static int dc[] = {-1, 1, -2, 2, -1, 1};
	static int n;
	static int r2,c2;
	static int min_val = Integer.MAX_VALUE;
	static boolean[][] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		check = new boolean[n][n];
		
		String[] tem = in.readLine().split(" ");
		int r1 = Integer.parseInt(tem[0]);
		int c1 = Integer.parseInt(tem[1]);
		r2 = Integer.parseInt(tem[2]);
		c2 = Integer.parseInt(tem[3]);
		
		int result = bfs(r1,c1,0);
		System.out.println(result);
	}

	private static int bfs(int a, int b, int d) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {a,b,d});
		check[a][b] = true;
		while(!queue.isEmpty()) {
			int[] tem = queue.poll();
			int r = tem[0];
			int c = tem[1];
			int cnt = tem[2];
			
			if(r==r2 && c==c2) return cnt;
			
			for(int i=0; i<6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr <0 || nc <0 || nr >= n || nc>=n || check[nr][nc]) continue;
				
				queue.offer(new int[] {nr,nc, cnt+1});
				check[nr][nc] = true;
			}
		}
		return -1;
	}
	
}






