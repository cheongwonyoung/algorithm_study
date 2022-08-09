package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution_1861_정사각형방 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();

		int tc = Integer.parseInt(in.readLine());
		
		// 상하좌우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		
		for(int i=1; i<=tc; i++) {
			int cnt = 1;
			int max_val = 1;
			int max_start = 0;
			list.clear();
			int n = Integer.parseInt(in.readLine());
			int[][] arr = new int[n][n];
			for(int j=0; j<n; j++) {
				String[] temp = in.readLine().split(" ");
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(temp[k]);
				}
			}
			
			for(int k=0; k<n; k++) {
				for(int j=0; j<n; j++) {
					int r = k;
					int c = j;
					
					int start = arr[r][c];
					cnt = 1;
					boolean flag = true;
					while(flag) {
						flag = false;
						for(int d=0; d<4; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							if(nr<0 || nc<0 || nr>=n || nc>=n) {

								continue;
							}
							else if(arr[nr][nc]== arr[r][c]+1) {	
								flag = true;
								cnt++;
								r = nr;
								c = nc;
								
								break;
							}
						}
					}
					if(max_val < cnt) {
						max_val = cnt;
						max_start = start;
					}
					else if(max_val == cnt) {
						if(start < max_start) {
							max_start = start;
						}
					}
				}
			}

			sb.append("#").append(i).append(" ").append(max_start).append(" ").append(max_val).append("\n");
			
		}
		System.out.println(sb);
	}
	
}









// 123
// 456
// 789

