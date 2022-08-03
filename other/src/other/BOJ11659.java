package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] temp1 = in.readLine().split(" ");
		int n = Integer.parseInt(temp1[0]);
		int m = Integer.parseInt(temp1[1]);

		int[] arr = new int[n];
		int[] arr_sum = new int[n];
		
		String[] temp2 = in.readLine().split(" ");
		for (int t = 0; t < n; t++) {
			arr[t] = Integer.parseInt(temp2[t]);
		}
		
		arr_sum[0] = arr[0];
		
		for(int l=1; l<n; l++) {
			arr_sum[l] = arr_sum[l-1] + arr[l];
		}
		
		
		
		for (int t = 0; t < m; t++) {
			String[] temp3 = in.readLine().split(" ");
			int i = Integer.parseInt(temp3[0]);
			int j = Integer.parseInt(temp3[1]);
			
			if(i-2<0) {
				sb.append(arr_sum[j-1]).append("\n");
			}
			else {
				sb.append(arr_sum[j-1] - arr_sum[i-2]).append("\n");
			}

		}
		System.out.println(sb);

	}
	

}
