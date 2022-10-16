package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1238 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		
		int n = Integer.parseInt(tem[0]);
		int m = Integer.parseInt(tem[1]);
		int x = Integer.parseInt(tem[2]);
		
		int[][] arr = new int[n+1][n+1];
		
		int result = 0;
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				arr[i][j] = 100000;
				if(i==x && j==x) arr[x][x] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			tem = in.readLine().split(" ");
			int t1 = Integer.parseInt(tem[0]);
			int t2 = Integer.parseInt(tem[1]);
			
			// 단방향 그래프 생성
			arr[t1][t2] = Integer.parseInt(tem[2]);
			
		}
		
//		for(int i=0; i<n+1; i++) {
//			for(int j=0; j<n+1; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(arr[i][j] > arr[i][k]+arr[k][j]) arr[i][j] = arr[i][k]+arr[k][j];
				}
			}
		}
		
//		for(int i=0; i<n+1; i++) {
//			for(int j=0; j<n+1; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int i=1; i<n+1; i++) {
			result = Math.max(result, arr[i][x] + arr[x][i]);
		}
		System.out.println(result);
	}
	
}
