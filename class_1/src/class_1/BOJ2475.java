package class_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2475 {
public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		int sum = 0;
		for(int i = 0; i<5; i++) {
			sum += Math.pow(Integer.parseInt(tem[i]),2);
		}
		
		System.out.println(sum%10);
		
		
	}
}
