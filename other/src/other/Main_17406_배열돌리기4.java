package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17406_배열돌리기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(temp[2]);
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			temp = in.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i = 0; i < k; i++) {
			temp = in.readLine().split(" ");
			int r = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			int s = Integer.parseInt(temp[2]);

			int row = r-s-1;
			int col = c-s-1;
			int limit = Math.min(n-row, m-col); 
			int nr = row;
			int nc = col;
			
			for(int spot = 0; spot < (row+limit)/2; spot++) {
				int cr = nr;
				int cc = nc;
				nr = cr + spot;
				nc = cc + spot;
				int tem=0;

				int row_cnt = 0;
				int col_cnt = 0;
				// 오른쪽으로 쭉
				while(true) {
					tem = arr[nr+row_cnt][nc+col_cnt+1];
					arr[nr+row_cnt][nc+col_cnt+1] = arr[nr+row_cnt][nc+col_cnt];
					col_cnt++;
					if(col_cnt==limit-1) {
						break;
					}
				}
				// 아래쪽으로 쭉
				while(true) {
					tem = arr[nr+row_cnt][nc+col_cnt+1];
					arr[nr+row_cnt][nc+col_cnt+1] = arr[nr+row_cnt][nc+col_cnt];
					col_cnt++;
					if(col_cnt==limit-1) {
						break;
					}
				}
				// 오른쪽으로 쭉
				while(true) {
					tem = arr[nr+row_cnt][nc+col_cnt+1];
					arr[nr+row_cnt][nc+col_cnt+1] = arr[nr+row_cnt][nc+col_cnt];
					col_cnt++;
					if(col_cnt==limit-1) {
						break;
					}
				}
				// 오른쪽으로 쭉
				while(true) {
					tem = arr[nr+row_cnt][nc+col_cnt+1];
					arr[nr+row_cnt][nc+col_cnt+1] = arr[nr+row_cnt][nc+col_cnt];
					col_cnt++;
					if(col_cnt==limit-1) {
						break;
					}
				}
			}
			
			
		}
		
	}
	
}
