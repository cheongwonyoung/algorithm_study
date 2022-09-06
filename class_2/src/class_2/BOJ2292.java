package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cnt = 1;
		int six = 1;
		while(n > six) {
			six += 6*cnt;
			cnt += 1;
		}
		System.out.println(cnt);
		
	}
	
}

