package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[100][100];
		int sum = 0;
		
		for(int i =1; i<=n; i++) {
			String[] temp = in.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			for(int j=y; j<y+10; j++) {
				for(int k=x; k<x+10; k++) {
					arr[j][k] = 1;
				
				}
			}
		}
	
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					sum += arr[j][k];
				}
			}
		
		System.out.println(sum);

	}
	
}
