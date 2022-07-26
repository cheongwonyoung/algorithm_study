package class_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int x = Integer.parseInt(temp[0]);
		int y = Integer.parseInt(temp[1]);
		int w = Integer.parseInt(temp[2]);
		int h = Integer.parseInt(temp[3]);
		int min = Math.min(Math.min(x, Math.abs(w-x)),Math.min(y, Math.abs(h-y)));
		
		System.out.println(min);
	}
}
