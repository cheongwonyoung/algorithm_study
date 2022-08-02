package class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(in.readLine());
			
			if(n==0) {
				sb.append(1 + " " + 0 + "\n");
			}
			else if(n==1) {
				sb.append(0 + " " + 1 + "\n");
			}
			else if(n==2) {
				sb.append(1 + " " + 1 + "\n");
			}
			else {
				int zero_cnt_pre = 0;
				int zero_cnt_nxt = 1;
				int zero_cnt_res = 0;
				int one_cnt_pre = 1;
				int one_cnt_nxt = 1;
				int one_cnt_res = 0;
				int cnt = 2;
				while(true) {
					zero_cnt_res = zero_cnt_pre + zero_cnt_nxt;
					one_cnt_res = one_cnt_pre + one_cnt_nxt;
					cnt++;
					if(cnt >= n) {
						sb.append(zero_cnt_res + " " + one_cnt_res + "\n");
						break;
					}
					zero_cnt_pre = zero_cnt_nxt;
					zero_cnt_nxt = zero_cnt_res;
					one_cnt_pre = one_cnt_nxt;
					one_cnt_nxt = one_cnt_res;
				}
			}
			
			
		}

		System.out.println(sb);
	}
}
