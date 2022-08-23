package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BOJ17135 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int n = Integer.parseInt(temp[0]); // 격자행 
		int m = Integer.parseInt(temp[1]); // 격자열
		int d = Integer.parseInt(temp[2]); // 사거리
		
		int result = 0; // 적의 최대 수
		
		int[] sum_row = new int[n]; // 열들의 합
		int[] sum_col = new int[m]; // 열들의 합
		int[][] arr = new int[n][m]; // 격자판
		
		for(int i=0; i<n; i++) {
			temp = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				sum_col[j] += arr[i][j]; 
			}
		}
		// 열의 합이 가장 큰 세곳에 배치 ( 앞에 오면 쏘면 된다. )
		if(d==1) {
			Arrays.sort(sum_col);		
			result = sum_col[m-3]+sum_col[m-2]+sum_col[m-1];
		}
		
		else if(d==2) {
			
			
		}

		else {
	
			
		}
		
		System.out.println(result);
		
	}
	
}
