package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String num = in.readLine();
		String[] numArr = num.split("");
		
		int val = Integer.parseInt(num);
		
		int res = 0;
		for (int i = 0; i < val; i++) {
			res =0;
			String[] temp = Integer.toString(i).split("");
			for (int j = 0; j < temp.length; j++) {
				res += Integer.parseInt(temp[j]);
			}
			res += i;
			if(val == res) {
				System.out.println(i);
				break;
			}
			if(i==val-1) {
				System.out.println(0);
			}
		}
		
		
	}
	
}
