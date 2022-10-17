package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 =in.readLine();
		String s2 =in.readLine();
		
		int len1 = s1.length();
		int len2 = s2.length();
		int max_val = 0;
		int[][] arr = new int[len1+1][len2+1];
		
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1] + 1;
					if(arr[i][j] > max_val) max_val = arr[i][j];
				}
			}
		}
		System.out.println(max_val);
		
	}
	
}
