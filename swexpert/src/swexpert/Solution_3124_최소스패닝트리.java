package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3124_최소스패닝트리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t<=T; t++) {
			String[] temp = in.readLine().split(" ");
			int v = Integer.parseInt(temp[0]);
			int e = Integer.parseInt(temp[1]);
			
			for(int i=0; i<e; i++) {
				temp = in.readLine().split(" ");
				int a = Integer.parseInt(temp[0]);
				int b = Integer.parseInt(temp[1]);
				int c = Integer.parseInt(temp[2]);
			}
			
		}
	}
	
}
