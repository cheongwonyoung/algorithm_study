package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14889 {
	static int n;
	static int[] team1;
	static int[] team2;

	static int[][] arr;
	static boolean[] check;
	
	static int min_val = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//nC2 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		arr = new int[n][n];
		team1 = new int[n/2];
		team2 = new int[n/2];
		check = new boolean[n];
		String[] temp;
		
		for(int i = 0; i<n; i++) {
			temp = in.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		comb(0, 0);
		System.out.println(min_val);
		
	}
	private static void comb(int cnt, int start) {
		int sum1 = 0;
		int sum2 = 0;
		if(cnt == n/2) {
			int c1 = 0;
			int c2 = 0;
			for(int i =0; i<n; i++) {
				if(c1!=n/2 && team1[c1]==i) {
					c1++;
					
				}
				else {
					team2[c2++] = i;
				}
			}
//			System.out.println("team1 : " + Arrays.toString(team1));
//			System.out.println("team2 : " + Arrays.toString(team2));
//			System.out.println();
//		
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < n/2; j++) {
					sum1 += arr[team1[i]][team1[j]];
					sum2 += arr[team2[i]][team2[j]];
					
				}
			}
			if(min_val > Math.abs(sum1-sum2)) min_val = Math.abs(sum1-sum2);
			
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(check[i]) continue;
			check[cnt] = true;
			team1[cnt] = i;
			comb(cnt+1, i+1);
			check[cnt] = false;
		}
		
	}
	
	
	
	
}