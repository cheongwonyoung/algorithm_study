package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12891 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		
		int s = Integer.parseInt(temp[0]);
		int p = Integer.parseInt(temp[1]);
		
		String[] dna = in.readLine().split("");
		
		temp = in.readLine().split(" ");
		int cnt_A = Integer.parseInt(temp[0]);
		int cnt_C = Integer.parseInt(temp[1]);
		int cnt_G = Integer.parseInt(temp[2]);
		int cnt_T = Integer.parseInt(temp[3]);
		
		for(int i=0; i<s; i++) {
			if(dna[i].equals("A")){
				cnt_A -= 1;
			}
			else if(dna[i].equals("C")){
				cnt_C -= 1;
			}
			else if(dna[i].equals("G")){
				cnt_G -= 1;
			}
			else if(dna[i].equals("T")){
				cnt_T -= 1;
			}
	
		}
		
		// cnt가 남아있을 때
		if(cnt_A >0 || cnt_C >0 || cnt_G >0 || cnt_T >0 ) {
			System.out.println(0);
		}
		
		
		
	}
	
	
}
