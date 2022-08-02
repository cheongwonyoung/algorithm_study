package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 테케
		int T = Integer.parseInt(in.readLine());
		
		// 테케 반복
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(in.readLine());
			// 배열생성
			int[][] arr = new int[n][n];
			// 배열 대입
			for (int j = 0; j < n; j++) {
				String[] temp = in.readLine().split("");
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(temp[k]);
				}
			}
			int sum = 0;			
			int t = 0;
			int q = 0;
			
			for(int s = 0; s < n; s++) {
				for(int l =n/2-t; l <=n/2+q; l++) {
					sum += arr[s][l];						
				}
				if(s<n/2) {
					t++;
					q++;
				}
				else {
					t--;
					q--;
				}
			}
			
			System.out.println("#"+(i+1)+" "+ sum);
		
		}

	}
	
}
