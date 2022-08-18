package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1541 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] sik = in.readLine().split("-");
		int len = sik.length;
		String[] temp = new String[len];
		int sum = 0;
		String tem = "";
		int[] total = new int[len];
		String[] sub;
		int result = 0;
		
		
		for(int i=0; i<len; i++) {	
			if(sik[i].equals("")) {
				total[i] = -1;
				continue;
			}
			sub = sik[i].split("");
			sum = 0;
			for(int j=0; j<sub.length; j++) {
				if(sub[j].equals("+")) {
					sum += Integer.parseInt(tem);
					tem = "";
				}
				else {
					tem += sub[j];
				}
			}
			sum += Integer.parseInt(tem);
			tem = "";
			total[i] = sum;
		}
		
		
		for(int i=0; i<len; i++) {
			
			
			if(i==0) {
				if(total[i]==-1) continue;
				else total[i] *= -1;
			}
			result -= total[i];

		}
			
			
		System.out.println(result);
	
	}
	
}
