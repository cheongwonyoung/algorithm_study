package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ14503 {
	
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n,m;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tem = in.readLine().split(" ");
		n = Integer.parseInt(tem[0]);
		m = Integer.parseInt(tem[1]);
		
		tem = in.readLine().split(" ");
		int r = Integer.parseInt(tem[0]);
		int c = Integer.parseInt(tem[1]);
		
		// 0:북, 1:동, 2:남, 3:서
		int d = Integer.parseInt(tem[2]); 
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			tem = in.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
			}
		}
		
		System.out.println(bfs(r,c,d,0));
		
	}

	private static int bfs(int r, int c, int d, int cnt) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r,c,d,cnt});
		while(!queue.isEmpty()) {
			int[] tem = queue.poll();
			r = tem[0];
			c = tem[1];
			d = tem[2];
			cnt = tem[3];
			
			// 현재 칸이 청소되어 있지 않다면 청소함
			if(arr[r][c]==0) {
				arr[r][c] = 2;
				cnt++;
			}
			
			// 사방탐색에 청소되지 않은 빈 칸이 없는 경우
			boolean check = false;
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
				
				// 사방탐색에 청소되지 않은 빈 칸이 있는 경우
				if(arr[nr][nc]==0) check=true; 
				
			}
			
			// 청소되지 않은 빈 칸이 있는 경우
			if(check) {
				// 북쪽을 바라봄
				if(d==0) {
					// 바라보는 방향 서쪽으로 변경, 서쪽이 청소되지 않았다면 전진
					if(c-1>=0 && arr[r][c-1]==0) {
						queue.offer(new int[] {r,c-1,3,cnt});
					}
					// 청소가 되어있다면 방향만 바꾸고 다시
					else {
						queue.offer(new int[] {r,c,3,cnt});
					}
				}
				// 동
				else if(d==1) {
					// 바라보는 방향 북쪽으로 변경, 북쪽이 청소되지 않았다면 전진
					if(r-1>=0 && arr[r-1][c]==0) {
						queue.offer(new int[] {r-1,c,0,cnt});
					}
					// 청소가 되어있다면 방향만 바꾸고 다시
					else {
						queue.offer(new int[] {r,c,0,cnt});
					}
				}
				// 남
				else if(d==2) {
					// 바라보는 방향 동쪽으로 변경, 동쪽이 청소되지 않았다면 전진
					if(c+1<m && arr[r][c+1]==0) {
						queue.offer(new int[] {r,c+1,1,cnt});
					}
					// 청소가 되어있다면 방향만 바꾸고 다시
					else {
						queue.offer(new int[] {r,c,1,cnt});
					}
				}
				// 서
				else if(d==3) {
					// 바라보는 방향 남쪽으로 변경, 남쪽이 청소되지 않았다면 전진
					if(r+1<n && arr[r+1][c]==0) {
						queue.offer(new int[] {r+1,c,2,cnt});
					}
					// 청소가 되어있다면 방향만 바꾸고 다시
					else {
						queue.offer(new int[] {r,c,2,cnt});
					}
				}
			}
			// 청소되지 않은 빈 칸이 없는 경우
			else {
				// 북쪽을 바라봄
				if(d==0) {
					// 남쪽으로 갈 수 있다면 이동
					if(r+1<n && arr[r+1][c]!=1) {
						queue.offer(new int[] {r+1,c,d,cnt});
					}
				}
				// 동
				else if(d==1) {
					// 서쪽으로 갈 수 있다면 이동
					if(c-1>=0 && arr[r][c-1]!=1) {
						queue.offer(new int[] {r,c-1,d,cnt});
					}
				}
				// 남
				else if(d==2) {
					// 북쪽으로 갈 수 있다면 이동
					if(r-1>=0 && arr[r-1][c]!=1) {
						queue.offer(new int[] {r-1,c,d,cnt});
					}
				}
				// 서
				else if(d==3) {
					// 동쪽으로 갈 수 있다면 이동
					if(c+1<m && arr[r][c+1]!=1) {
						queue.offer(new int[] {r,c+1,d,cnt});
					}
				}
			}
			
			
		}
		return cnt;
	}

}










