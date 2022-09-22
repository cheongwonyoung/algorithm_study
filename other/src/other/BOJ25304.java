package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ25304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		int sum = 0;
		for(int i = 0; i<n; i++) {
			String[] temp = in.readLine().split(" ");
			sum += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
		}
		if(sum == x)System.out.println("Yes");
		else System.out.println("No");
	}
	
}
