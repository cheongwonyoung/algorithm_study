package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1952_수영장 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] tem = in.readLine().split(" ");
			int day = Integer.parseInt(tem[0]);
			int oneMonth = Integer.parseInt(tem[1]);
			int threeMonth = Integer.parseInt(tem[2]);
			int year = Integer.parseInt(tem[3]);
			
			int[] dp = new int[13];
			
			tem = in.readLine().split(" ");
			
			for(int i=1; i<=12; i++) {
				// 12개월, 3개월, 1개월, 1일
				int dayVal = day*Integer.parseInt(tem[i-1]);
				
				
			}
			
		}
	}
	
}



