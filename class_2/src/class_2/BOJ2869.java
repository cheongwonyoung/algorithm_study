package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ2869 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] tem = in.readLine().split(" ");
		int A = Integer.parseInt(tem[0]);
		int B = Integer.parseInt(tem[1]);
		int V = Integer.parseInt(tem[2]);
		
		int cnt = (V-B) / (A-B);
		if( (V-B) % (A-B) != 0){
			cnt++;
		}
		System.out.println(cnt);
	}
	
}
