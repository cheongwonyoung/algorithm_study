package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_16926_배열돌리기1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int r = Integer.parseInt(temp[2]);
		
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			temp = in.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		// 대각선으로 시작점 지정
		// 아래로 n, n-1, n-2, .. 까지
		// 우로로 n, n-1, n-2, .. 까지
		// 위로 0, 1, 2, .. 까지
		// 좌로 0, 1, 2, .. 까지
		// 하 우 상 좌
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};

		int half = Math.min(n, m)/2;
		 
		for(int i=0; i<half; i++) {
			// 좌하, 우하, 우상, 좌상
			int[] s = {arr[n-1-i][i+1], arr[n-1-i][m-2-i], arr[i+1][m-1-i], arr[i][m-1-i+1]}; // (0,0), (n,0), (n,n), (0,n)
			int nr=i;
			int nc=i;
			int pr=i;
			int pc=i;

			for(int j=0; j<4; j++) {
				int pre_val = arr[pr][pc];
				while(true) {
					pr=nr; // 시작(이전 row)
					pc=nc; // 시작(이전 col)
					
					nr = pr+dr[j]; // 다음 row
					nc = pc+dc[j]; // 다음 col
					
					int next_val = arr[nr][nc];
				
					if(!(nr<i) || !(nr>=n-i) || !(nc<i) || !(nc>=n-i))
						arr[nr][nc] = pre_val;
					else {
						nr = pr; 
						nc = pc;
						break;
					}
					pre_val = next_val;
					if(j==0 && nr==n-1-i && nc==i) break;
					if(j==1 && nc==m-1-i &&nr==n-1-i ) break;
					if(j==2 && nc==m-1-i && nr==i) break;
					if(j==3 && nr==i && nc==i) break;
				}
				
				arr[nr][nc]=s[j];
				
			}
			for(int q=0; q<n; q++) {
				for(int a=0; a<m; a++) {
					System.out.print(arr[q][a] + " ");
				}
				System.out.println();
			}
			
		}
		
		
	}
	
}
