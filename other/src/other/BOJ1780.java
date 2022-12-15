package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1780 {
	
	static int[][] arr;
	static int minus=0;
	static int zero=0;
	static int one=0;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] tem = in.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
			}
		}
		
		dfs(0,0,n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}

	private static void dfs(int r, int c, int n) {
		boolean check = false;
		int start = arr[r][c];
		for(int i=r; i<n+r; i++) {
			for(int j=c; j<n+c; j++) {
				if(start != arr[i][j]) {
					check = true;
				}
			}
		}
		
		if(!check) {
			if(start==-1) {
				minus +=1;
			}
			else if(start==0) {
				zero+=1;
			}
			else {
				one += 1;
			}
		}
		else {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					dfs(r+(n/3*i),c+(n/3*j),n/3);
				}
			}
		}
		
	
		
		
	}

}
