package class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1463 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n+1];
		// 1 0 
		// 2 1 
		// 3 1 
		// 4 2 
		// 5 3 
		// 6 2 
		// 7 3 
		
		for(int i=2; i<n+1; i++) {
			if(i%2==0 && i%3==0) {
				arr[i] = Math.min(Math.min(arr[i/2], arr[i/3]),arr[i-1])+1;
			}
			else if(i%2==0) {
				arr[i] = Math.min(arr[i/2],arr[i-1])+1;				
			}
			else if(i%3==0) {				
				arr[i] = Math.min(arr[i/3],arr[i-1])+1;
			}
			else {
				arr[i] = arr[i-1]+1;
			}
		}
		System.out.println(arr[n]);
		
	}
	
}
