package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15654_n과m5 {
	
	static int n;
	static int m;
	static int[] result;
	static int[] input;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		
		n = Integer.parseInt(tem[0]);
		m = Integer.parseInt(tem[1]);
		
		tem = in.readLine().split(" ");
		input = new int[n];
		visit = new boolean[n];
		result = new int[m];
		for(int i =0; i<n; i++) {
			input[i] = Integer.parseInt(tem[i]);
		}
		
		Arrays.sort(input);
		per(0);
		System.out.println(sb);
	}
	
	public static void per(int cnt) {
		if(m==cnt) {
			for(int temp: result) {
				sb.append(temp).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			result[cnt] = input[i];
			per(cnt+1);
			visit[i] = false;
		}
		
		
	}
}
