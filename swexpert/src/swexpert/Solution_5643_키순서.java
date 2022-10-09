package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5643_키순서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int cnt = 0;
			int n = Integer.parseInt(in.readLine());
			int m = Integer.parseInt(in.readLine());
			
			int[][] arr = new int[n][n];
			
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					if(r==c) {
						arr[r][c] = 0;
						continue;
						
					}
					arr[r][c] = 100000;
				}
			}
			
			for(int i=0; i<m; i++) {
				String[] temp = in.readLine().split(" ");
				arr[Integer.parseInt(temp[0])-1][Integer.parseInt(temp[1])-1] = 1;
			}
			
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}
			
			int narr[] = new int[n];
			
			for(int i = 0; i<n; i++) {
				for(int j=0; j<n; j++) {
					narr[j] += Math.min(arr[i][j], arr[j][i]);					
				}
			}
			
			for(int i = 0; i<n; i++) {
				if(narr[i] <100000) cnt++;
				
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
}
