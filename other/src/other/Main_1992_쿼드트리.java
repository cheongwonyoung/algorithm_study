package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static int[][] image;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		image = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String[] temp = in.readLine().split("");
			for(int j=0; j<n; j++) {
				image[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		func(0,0,n);
		
		System.out.println(sb);
	}
	
	public static void func(int r, int c, int len) {
		int start = image[r][c];
		boolean check = true;
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(start != image[i][j]) {
					check = false;
					break;
				}
			}
		}
		if(check) sb.append(start);
		else {
			sb.append("(");
			func(r, c, len/2);
			func(r, c+len/2, len/2);
			func(r+len/2, c, len/2);
			func(r+len/2, c+len/2, len/2);
			sb.append(")");
		}
	}
	
}
