package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11049 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cnt = 0;
		int sCnt = 0;

		while (n > 1) {

			// 5원짜리로 다 되면
			if (n % 5 == 0) {
				cnt = n / 5;
				break;
			}

			n -= 2;
			sCnt += 1;

		}

		if (n == 1 || (n < 0 && sCnt == 0)) {
			System.out.println(-1);
		} else {
			System.out.println(cnt + sCnt);
		}

	}
}
