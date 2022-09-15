package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int[][] arr = new int[15][15];
		for(int i=1; i<=14; i++) {
			arr[0][i] = i;
		}
		
		for(int i = 1; i<=14; i++) {
			for(int j = 1; j<=14; j++) {
				for(int k = 1; k<=j; k++) {	
					arr[i][j] += arr[i-1][k];
				}				
			}
		}
		
		for(int i =0; i<T; i++) {
			int k = Integer.parseInt(in.readLine());
			int n = Integer.parseInt(in.readLine());
//			System.out.println(arr[k][n]);
			sb.append(arr[k][n]).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
