package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2660 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder leader = new StringBuilder();
		StringBuilder idx = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int cnt = 0;
		String[] tem;
		int[][] arr = new int[n+1][n+1];
		int[] result = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				arr[i][j] = 100000;
			}
		}
		
		while(true) {
			tem = in.readLine().split(" ");
			int a = Integer.parseInt(tem[0]);
			int b = Integer.parseInt(tem[1]);
			
			if(a==-1) break;
			
			arr[a][b] = 1;
			arr[b][a] = 1;
			
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			int maxVal = -1;
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				if(maxVal < arr[i][j]) maxVal = arr[i][j]; 
			}
			result[i] = maxVal;
		}
		
		int min_val = 100000;
		for(int i=1; i<=n; i++) {
			if(min_val > result[i]) min_val = result[i];
		}
		
		for(int i=1; i<=n; i++) {
			if(min_val==result[i]) {
				cnt++;
				idx.append(i).append(" ");
			}
		}
		leader.append(min_val).append(" ").append(cnt);
		System.out.println(leader);
		System.out.println(idx);
	
	}
	
}
