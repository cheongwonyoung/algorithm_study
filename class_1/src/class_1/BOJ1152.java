package class_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1152 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String text = in.readLine();
		int n= text.split(" ").length;
		if(n==0) {
			
		}
		else if(text.split(" ")[0].equals("")) {
			n -= 1;
		}
		
		System.out.println(n);
		
	}
}

