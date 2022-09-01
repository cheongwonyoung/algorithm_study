package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11050 {
	static int n, k;
	static int[] result;
	static boolean[] check;
	static int total = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		n =  Integer.parseInt(tem[0]);
		k =  Integer.parseInt(tem[1]);
		result = new int[k];
		check = new boolean[n+1];
		
		comb(0, 1);
		System.out.println(total);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==k) {
			total+=1;
			return;
		}
		
		for(int i=start; i<n+1; i++) {
			if(check[i]) continue;
			check[i] = true;
			result[cnt] = i;
			comb(cnt+1, i+1);
			check[i] =false;
		}
	}
	
}
