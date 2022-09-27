package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15655 {
	
	static int n,m;
	static int[] arr; 
	static int[] result;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		temp = in.readLine().split(" ");
		check = new boolean[n+1];
		arr = new int[n];
		
		result = new int[m];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(arr);
		
		perm(0, 0);
		System.out.println(sb);
	}
	
	static void perm(int cnt, int num) {
		if(cnt == m) {
			for(int i = 0; i<m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num; i<n; i++) {
			if(check[i]) continue;
			check[i] = true;
			result[cnt] = arr[i];
			perm(cnt+1, i+1);
			check[i] = false;
		}
		
	}
	
	
}
