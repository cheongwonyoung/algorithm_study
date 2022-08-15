package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5215_햄버거다이어트 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int t = Integer.parseInt(in.readLine());
		 for(int i =1; i<=t; i++) {
			 String[] temp = in.readLine().split(" ");
			 int n = Integer.parseInt(temp[0]);
			 int l = Integer.parseInt(temp[1]);
			 int result = 0;
			 int sum = 0;
			 
			 int[] ti = new int[n]; 
			 int[] ki = new int[n]; 
			 
			 for(int j = 0; j<n; j++) {
				 temp = in.readLine().split(" ");
				 ti[j] = Integer.parseInt(temp[0]);
				 ki[j] = Integer.parseInt(temp[1]);
				 sum += ki[j];
			 }
			 
			System.out.println(sum); 
			 
			 for(int j = n-1; j>=0; j++) {
				 ki[j]
			 }
			 
			 sb.append("#").append(i).append(" ").append(result);
			 
		 }
	}
	
}
