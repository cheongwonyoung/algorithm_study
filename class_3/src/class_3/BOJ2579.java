package class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n+1];
		int[] sum_arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		if(n==1) {
			sum_arr[1] = arr[1];
		}
		else if(n==2) {
			sum_arr[2] = arr[1]+arr[2];
		}
		else {
		sum_arr[0] = 0;
		sum_arr[1] = arr[1]; // 10
		sum_arr[2] = arr[1]+arr[2]; // 30 
			for(int i = 3; i<=n; i++) {
				sum_arr[i] = Math.max(sum_arr[i-2]+arr[i], sum_arr[i-3]+arr[i-1]+arr[i]);
			}
		}

		System.out.println(sum_arr[n]);
		
	}	
		
}
	


