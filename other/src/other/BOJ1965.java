package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1965 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        
        String[] tem = in.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tem[i]);
            dp[i] = 1;
        }
        
        int result = 0;
        for(int i=1; i<n; i++) {
        	for(int j=0; j<i; j++) {
        		if(arr[j] < arr[i]) {
        			if(dp[i] < dp[j]+1) dp[i] = dp[j]+1;
        			
        		}
        	}
        	if(result < dp[i]) result = dp[i];
        }
        
        System.out.println(result);
        
    }

}