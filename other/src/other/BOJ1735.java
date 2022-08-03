package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1735 {
	
	public static void uc(int n1, int m1, int n2, int m2) {
		if (m1==m2) return;
		uc(n1,m1,n2,m2);
		if(m1 < m2) {
			m1 += m1;
			n1 += n1;
		}
		else if(m2 < m1) {
			m2 += m2;
			n2 += n2;
		}
		
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp1 = in.readLine().split(" ");
		int n1 = Integer.parseInt(temp1[0]);
		int m1 = Integer.parseInt(temp1[1]);
		
		String[] temp2 = in.readLine().split(" ");
		int n2 = Integer.parseInt(temp2[0]);
		int m2 = Integer.parseInt(temp2[1]);
		
		int temp_m1=m1;
		int temp_m2=m2;
		int temp_n1=n1;
		int temp_n2=n2;
		
		while(!(m1==m2)) {
			
			if(m1 < m2) {
				m1 += temp_m1;
				n1 += temp_n1;
			}
			
			else if(m1 > m2){
				m2 += temp_m2;
				n2 += temp_n2;	
			}
			
			
			
		}

		
		
		System.out.println(n1+n2 +" "+m1);
		
		
	}
	
}
