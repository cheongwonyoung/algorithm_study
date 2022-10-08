package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11403 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][n];
		
		for(int r=0; r<n; r++) {
			String[] tem = in.readLine().split(" ");
			for(int c=0; c<n; c++) {
				arr[r][c] = Integer.parseInt(tem[c]);
			}
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(Math.max(arr[i][j], arr[i][k]+arr[k][j])>1) {
						arr[i][j] = 1;
						
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
	}
		
	System.out.println(sb);
	}
}
