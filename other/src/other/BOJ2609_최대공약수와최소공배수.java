package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2609_최대공약수와최소공배수 {
	
	private static int ucl(int n1, int n2) {
		if(n1%n2==0) return n2;
		return ucl(n2, n1%n2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		
		int n1 = Integer.parseInt(temp[0]);
		int n2 = Integer.parseInt(temp[1]);
		
		int min_snum = ucl(n1, n2);
		int max_snum = 0;
		int val = 1;
		
		while(true) {
			if(((min_snum*val)%n1==0) && ((min_snum*val)%n2==0)) {
				max_snum = min_snum*val;
				break;
			}
			else {
				val++;
			}
		}
				
				
		System.out.println(min_snum);
		System.out.println(max_snum);
		
	}
	
}
