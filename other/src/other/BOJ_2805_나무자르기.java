package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2805_나무자르기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		int n = Integer.parseInt(tem[0]); // 나무의 수
		int m = Integer.parseInt(tem[1]); // 나무의 길이
		
		int[] arr = new int[n]; // 나무
		long  max_val = Integer.MIN_VALUE;
		long  min_val = 0;
		
		tem = in.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tem[i]);
			if(max_val < arr[i]) max_val = arr[i];
		}
		
		max_val *= 2;
		long maxlen = 0;
		
		while(min_val<=max_val ) {
			long  mid = (max_val + min_val)/2;
			
			long  sum = 0;
			for(int i = 0; i<n; i++) {
				if(arr[i]-mid<0) continue;
				sum += (arr[i]-mid);
			}
			if(m<sum) {
				if(maxlen < mid) maxlen = mid; 
				min_val = mid+1;
			}
			
			else if(m>sum) max_val = mid-1;
			else {
				if(maxlen < mid) maxlen = mid; 
				break;
			}
			
		}
		
		System.out.println(maxlen);
		
		
	}
	
}

