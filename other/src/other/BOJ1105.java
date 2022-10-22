package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1105 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		String[] l = tem[0].split("");
		String[] r = tem[1].split("");
		
		int cnt=0;
		 	
		// 두 수가 같을 때 (하나에 들어있는 8의 개수가 답)
		if(l.equals(r)) {
			for(String temp : l) {
				if(temp.equals("8")) {
					cnt++;
				}
			}
		}
		// 자리수가 같을 때(맨 앞부터 8이 있는 개수가 답)
		else if(l.length==r.length) {
			for(int i=0; i<l.length; i++) {
				if(l[i].equals(r[i])) {
					if(!l[i].equals("8"))continue;
					cnt++;
				}
				else {
					break;
				}
			}
			
			
		}
		// 자리수가 다를 때(0)
		else {
			cnt = 0;
		}
		
		System.out.println(cnt);
		
		
	}
	
}
