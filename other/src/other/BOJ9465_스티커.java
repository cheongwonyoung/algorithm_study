package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9465_½ºÆ¼Ä¿ {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];
			
			
			for(int i = 0; i<2; i++) {
				String[] tem = in.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(tem[j]);
					dp[i][j] = Integer.parseInt(tem[j]);
				}
			}

			for(int i =1; i<n; i++) {
				if(i==1) {
					if(dp[0][i] < dp[1][i-1]+arr[0][i]) dp[0][i] = dp[1][i-1]+arr[0][i]; 
					if(dp[1][i] < dp[0][i-1]+arr[1][i]) dp[1][i] = dp[0][i-1]+arr[1][i];
				}
				else {
					dp[0][i] = Math.max(Math.max(dp[1][i-1] + arr[0][i], dp[1][i-2] + arr[0][i]), dp[0][i-2]+ arr[0][i]);
					dp[1][i] = Math.max(Math.max(dp[0][i-1] + arr[1][i], dp[0][i-2] + arr[1][i]), dp[1][i-2] + arr[1][i]);
					
				}

			}
			
			sb.append(Math.max(dp[1][n-1], dp[0][n-1])).append("\n");
			
		}
		System.out.println(sb);
		
	}

}