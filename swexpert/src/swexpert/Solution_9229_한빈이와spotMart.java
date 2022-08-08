package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_9229_한빈이와spotMart {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스
		int tc = Integer.parseInt(in.readLine());
		for(int i=1; i<=tc; i++) {
			String[] temp = in.readLine().split(" ");
			
			// 과자 봉지의 개수와 무게 합 제한
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]);
			
			// 과자 봉지 무게 배열
			int[] arr = new int[n];
			temp = in.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(temp[j]);
			}

			int max_val = -1;
			for(int j=0; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					if(arr[j]+arr[k] <= m && arr[j]+arr[k]>max_val) {
						max_val = arr[j]+arr[k];
					}
				}
		
			}
			sb.append("#").append(i).append(" ").append(max_val).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
	



