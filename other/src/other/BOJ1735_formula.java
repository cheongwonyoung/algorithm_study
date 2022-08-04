package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1735_formula {
	
	public static int ucl(int a, int b) {
		if(a%b==0) return b;
		else {
			return ucl(b, a%b);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = in.readLine().split(" ");
		int n1 = Integer.parseInt(temp[0]);
		int m1 = Integer.parseInt(temp[1]);
		temp = in.readLine().split(" ");
		int n2 = Integer.parseInt(temp[0]);
		int m2 = Integer.parseInt(temp[1]);
		
		int mom = m1*m2;
		int son = m1*n2 + m2*n1;
		
		int gong = ucl(son,mom);
		
		sb.append(son/gong).append(" ").append(mom/gong).append("\n");
		System.out.println(sb);
	}
	
}
