package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ19622 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][3];
		
		for(int i=0; i<n; i++) {
			String[] tem = in.readLine().split(" ");
			int start = Integer.parseInt(tem[0]);
			int end = Integer.parseInt(tem[1]);
			int time = Integer.parseInt(tem[2]);
			
			arr[i][0] = start;
			arr[i][1] = end;
			arr[i][2] = time;
		}
		
		if(n==1) {
			System.out.println(arr[0][2]);
		}
		else if(n==2) {
			System.out.println(Math.max(arr[0][2], arr[1][2]));
		}
		else {
				
			int[] dp = new int[n];
			
			dp[0] = arr[0][2];
			dp[1] = arr[1][2];
			int maxVal = dp[0];
			for(int i=2; i<n; i++) {
				dp[i] = arr[i][2] + maxVal;
				maxVal = Math.max(maxVal, dp[i-1]);
			}
			
			System.out.println(Math.max(dp[n-1], maxVal));
		}
		
	}
}
