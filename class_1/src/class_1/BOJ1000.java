package class_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1000 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] num = in.readLine().split(" ");
		int a = Integer.parseInt(num[0]);
		int b = Integer.parseInt(num[1]);
		
		System.out.println(a+b);
	}
}
