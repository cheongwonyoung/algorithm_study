package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ1932 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		int max_val = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			String[] tem = in.readLine().split(" ");
			for(int j=0; j<tem.length; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		dp[0][0] = arr[0][0];
		
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i+1; j++) {
				if(dp[i][j]<dp[i-1][j]+arr[i][j]) dp[i][j]=dp[i-1][j]+arr[i][j];
				if(j==0) continue;
				if(dp[i][j]<dp[i-1][j-1]+arr[i][j]) dp[i][j]=dp[i-1][j-1]+arr[i][j];
				
				
			}
		}

		
			for(int j=0; j<n; j++) {
				if(max_val < dp[n-1][j]) max_val = dp[n-1][j];
			}
			System.out.println(max_val);
		
		
	}


	
}
