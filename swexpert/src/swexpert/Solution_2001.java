package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int i=0; i<T; i++) {
			String[] temp = in.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]);
			
			int[][] arr = new int[n][n];
			
			for(int j=0; j<n; j++) {
				temp = in.readLine().split(" ");
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(temp[k]);
				}
			}
			int max_val = Integer.MIN_VALUE;
			for(int l=0; l<n-m+1; l++) {
				for(int p=0; p<n-m+1; p++) {
					int sum = 0;
					for(int r=0; r<m; r++) {
						for(int c=0; c<m; c++) {
							sum += arr[l+r][p+c];
						}
					}
					
					if(max_val < sum) {
						max_val = sum;
					}
				}
			}
			sb.append("#").append(i+1).append(" ").append(max_val).append("\n");
		}
		System.out.println(sb);
		
	}	
	
}
