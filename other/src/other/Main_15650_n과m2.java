package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15650_n과m2 {
	static int n;
	static int m;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");

		n = Integer.parseInt(tem[0]);
		m = Integer.parseInt(tem[1]);
		
		result = new int[m];

		
		per(0, 1);
		System.out.println(sb);
	}

	public static void per(int cnt, int start) {
		if (cnt == m) {
			for (int temp : result) {
				sb.append(temp).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n; i++) {

			result[cnt] = i;
			per(cnt+1, i+1);

			
		}

	}

}
