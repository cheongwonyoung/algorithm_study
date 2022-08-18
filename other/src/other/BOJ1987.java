package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1987 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		
		int r = Integer.parseInt(temp[0]);
		int c = Integer.parseInt(temp[1]);
		
		String[][] arr = new String[r][c];
		for(int i=0; i<r; i++) {
			temp = in.readLine().split("");
			for(int j=0; j<c; j++) {
				arr[i][j] = temp[j];
			}
		}
		
		
		
	}
	
}
