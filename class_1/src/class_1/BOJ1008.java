package class_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1008 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] num = in.readLine().split(" ");
		double a = Double.parseDouble(num[0]);
		double b = Double.parseDouble(num[1]);
		
		System.out.println(a/b);
	}
}
