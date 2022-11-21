package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15657 {
	
	static int n,m;
	static int[] arr,result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] tem = in.readLine().split(" ");
		n = Integer.parseInt(tem[0]);
		m = Integer.parseInt(tem[1]);
		
		arr = new int[n];
		result = new int[m];
		
		tem = in.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tem[i]);
		}
		
		Arrays.sort(arr);
		
		perm(0,0);
		System.out.println(sb);
	}

	private static void perm(int cnt, int num) {
		if(m==cnt) {
			for(int i=0; i<m; i++) {
//				System.out.print(result[i] + " ");
				sb.append(result[i]).append(" ");
			}
//			System.out.println();
			sb.append("\n");
			return;
		}
		
		for(int i=num; i<n; i++) {
			result[cnt] = arr[i];
			perm(cnt+1, i);

		}
	}
	
}
