package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(in.readLine());
			int[][] dp = new int[n+1][2];

			if(n==0) {
				dp[0][0] = 1;
			}
			else if(n==1) {
				dp[1][1] = 1;
			}
			else {
					dp[0][0] = 1;
					dp[1][1] = 1;
		
					
					
					for(int i =2; i<=n; i++) {
						
						dp[i][0] =  dp[i-1][0] + dp[i-2][0];
						dp[i][1] =  dp[i-1][1] + dp[i-2][1];
					
					}
			}
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
			
			
		}
		System.out.println(sb);
		
		
	}
	
}
