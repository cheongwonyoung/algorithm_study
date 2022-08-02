package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1954 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(in.readLine());
			
			if(n==1) {
				System.out.println("#1");
				System.out.println(1);
				continue;
			}
			
			int[][] arr = new int[n][n];
			int num = 1;
			int row = 0;
			int col = 0;
			int cnt = 0;
			int[][] dr = {{0,1}, {1,0}, {0,-1},{-1,0}};
			int[] d;
			arr[row][col] = num++;
			while(true) {
				d = dr[cnt%4];
				if(!(arr[row+d[0]][col+d[1]]==0) ) break;
				
				while(true) {
					
					if(row+d[0]<0 || col+d[1] < 0 || col+d[1] >=n || row+d[0] >=n || !(arr[row+d[0]][col+d[1]]==0) ) {
						cnt++;
						break;
					}
					else {
						row = row+d[0];
						col = col+d[1];
						arr[row][col] = num++;
					}
						
				}
			}
			System.out.println("#"+(i+1));
			for(int j=0; j<n; j++) {
				for(int l=0; l<n; l++) {
					System.out.print(arr[j][l] + " ");
				}
				System.out.println();
			}
			
		}
	
	}
	
}
