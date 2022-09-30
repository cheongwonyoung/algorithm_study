package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11048 {
	// 하, 우, 하우
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int[][] arr = new int[n][m];
		int[][] result = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			temp = in.readLine().split(" ");
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);	
				result[i][j] = Integer.parseInt(temp[j]);	
			}
		}
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				for(int k=0; k<3; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if(nr <0 || nc <0 || nc >=m || nr>=n) {
						continue;
					}
					
					if(result[nr][nc] < result[i][j] + arr[nr][nc])
						result[nr][nc] = result[i][j] + arr[nr][nc];
				}
			}
			
		}
		
		System.out.println(result[n-1][m-1]);
		
	}
}
