package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2389 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int n = Integer.parseInt(in.readLine());
		// 3, 5
		
		while(true) {
			n -= 3;
			cnt++;
			
			if(n<3 && n>0) {
				cnt = -1;
				break;
			}
			
			if(n%5==0) {
				cnt += (n/5);
			}
			
		}
		
		System.out.println(cnt);
		
		
	}
	
	
}
