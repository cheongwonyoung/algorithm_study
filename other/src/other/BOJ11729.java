package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
	static int cnt=0;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		StringBuilder result = new StringBuilder();
		hanoi(n, 1, 2, 3);
		result.append(cnt).append("\n").append(sb);
		System.out.println(result);
	}

	private static void hanoi(int n, int start, int temp, int end) {
		if(n==1) {
			sb.append(start).append(" ").append(end).append("\n");
			cnt++;
			return;
		}
		
		hanoi(n-1, start, end, temp);
		sb.append(start).append(" ").append(end).append("\n");
		cnt++;
		hanoi(n-1, temp, start, end);
		
	}
	
}
