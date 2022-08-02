package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1208 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int T=1; T<=10; T++) {
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[100];
			String[] temp = in.readLine().split(" ");
			for(int i = 0; i<100; i++) {
				arr[i] = Integer.parseInt(temp[i]);
			}
			int max_num = Integer.MIN_VALUE;
			int max_idx =-1;
			int min_num = Integer.MAX_VALUE;
			int min_idx =-1;
			for(int j=0; j<n; j++) {
				max_num = Integer.MIN_VALUE;
				max_idx =-1;
				min_num = Integer.MAX_VALUE;
				min_idx =-1;
				for(int k=0; k<100; k++) {
					if(arr[k] > max_num) {
						max_num = arr[k];
						max_idx = k;
					}
					if(arr[k] < min_num) {
						min_num = arr[k];
						min_idx = k;
					}
				}

//				if(max_num == min_num) break;
				arr[max_idx] -= 1;
				arr[min_idx] += 1;
								
			}
			max_num = Integer.MIN_VALUE;
			min_num = Integer.MAX_VALUE;

			for(int k=0; k<100; k++) {
				
				if(arr[k] > max_num) {
					max_num = arr[k];
					max_idx = k;
				}
				if(arr[k] < min_num) {
					min_num = arr[k];
					min_idx = k;
				}
			}

			sb.append("#").append(T).append(" ").append(arr[max_idx]-arr[min_idx]).append("\n");
		}
		System.out.println(sb);
		
		
	}
	
}
