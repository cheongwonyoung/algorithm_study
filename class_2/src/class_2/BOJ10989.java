package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10989 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i<n; i++) {
			sb.append(arr[i]).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
}
