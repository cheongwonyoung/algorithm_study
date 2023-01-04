package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ3187 {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int r,c;
	static boolean[][] check;
	static String[][] arr;
	
	// 양이 살아남으면 양수로 세고, 늑대가 살아남으면 음수로 셈
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		r = Integer.parseInt(tem[0]);
		c = Integer.parseInt(tem[1]);
		
		
		arr = new String[r][c];
		result = new int[r][c];
		check = new boolean[r][c];
		
		int wolfCnt = 0;
		int sheepCnt = 0;
		
		for(int i=0; i<r; i++) {
			tem = in.readLine().split(""); 
			for(int j=0; j<c; j++) {
				arr[i][j] = tem[j];
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(!arr[i][j].equals("#") && !check[i][j]) {					
					bfs(i,j);
				}
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(result[i][j]>0) {
					sheepCnt += result[i][j];
				}
				else {
					wolfCnt -= result[i][j];
				}
			}
		}
		
		System.out.println(wolfCnt + " " + sheepCnt);
		
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {i,j});
		check[i][j] = true;
		
		int sheep = 0;
		int wolf = 0;
		
		while(!queue.isEmpty()) {
			
			int[] temp = queue.poll();
			int ti = temp[0];
			int tj = temp[1];
			
			// 늑대
			if(arr[ti][tj].equals("v")) {
				wolf++;
			}
			// 양
			else if(arr[ti][tj].equals("k")) {
				sheep++;
			}
			
			for(int d=0; d<4; d++) {
				int nr = dr[d] + ti;
				int nc = dc[d] + tj;
				
				if(nr<0 || nc<0 || nr>=r || nc>=c || check[nr][nc] || arr[nr][nc].equals("#")) continue;
				
				queue.offer(new int[] {nr,nc});
				check[nr][nc] = true;	
			}
			
			
		}
		
		if(sheep > wolf) {
			result[i][j] = -sheep;
		}
		else {
			result[i][j] = wolf;
		}
		
	}

}











