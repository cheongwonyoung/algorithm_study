package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		int[] arr = new int[n+1];
		
		if(n<3) {
			for(int i=1; i<=n; i++) {
				arr[i] = n;			
			}
		}
		else {
			arr[1] = 1;
			arr[2] = 2;
			for(int i=3; i<=n; i++) {
				arr[i] = arr[i-1]%10007 + arr[i-2]%10007;				
			}
		}

		System.out.println(arr[n]%10007);

		
	}
	
	
}
