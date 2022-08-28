package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_낚시터 {
	static int cnt,cnt2, n, min_val = Integer.MAX_VALUE;
	static int[] per_result;
	static boolean[] check;
	static boolean[] visit1;
	static boolean[] visit2;
	static int[][] gate;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(in.readLine()); // 낚시터 자리의 개수
			check = new boolean[3];
			gate = new int[3][2]; // 출입구 정보
			per_result = new int[3];
			for (int q = 0; q < 3; q++) { // 3개의 출입구 정보
				String[] tem = in.readLine().split(" ");
				gate[q][0] = Integer.parseInt(tem[0]); // 출입구의 위치
				gate[q][1] = Integer.parseInt(tem[1]); // 해당 출입구에 대기하는 낚시꾼 수
			}
			per(0);
			System.out.println(min_val);
		}
	}

	public static void per(int cnt) {
		if (cnt == 3) {
			visit1 = new boolean[n+1];
			visit2 = new boolean[n+1];
			visit1[0] = true;
			visit2[0] = true;
			position(per_result[0]);
			position(per_result[1]);
			position(per_result[2]);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (check[i])
				continue;
			per_result[cnt] = i;
			check[i] = true;
			per(cnt + 1);
			check[i] = false;

		}

	}

	// n은 몇번째 게이트인지 gate[n][0], gate[n][1] // 출입구 위치, 그 출입구에 대기자 수
	public static void position(int n) {
		int p = gate[n][0]; // 게이트 위치
		int w = gate[n][1]; // 게이트에 대기자 수

		int move = 0, move2 = 0;
		for (int i = 0; i < w; i++) {
			// 왼 - 오
			while (true) {
				if (p - move > 0  && !visit1[p - move] ) {
					visit1[p - move] = true;
					cnt += move + 1;
					break;
				}
				if ( p + move <= n && !visit1[p + move]) {
					visit1[p + move] = true;
					cnt += move + 1;
					break;
				}
				move++;

			}
			System.out.println("??");

			// 오 - 왼
			while (true) {
				if ( p + move2 <= n && !visit2[p + move2]) {
					visit2[p + move2] = true;
					cnt2 += move2 + 1;
					break;
				}
				if ( p - move2 > 0 && !visit2[p - move2]) {
					visit2[p - move2] = true;
					cnt2 += move2 + 1;
					break;
				}
				move2++;
			}
		}
		if(move > move2) {
			if(move2 < min_val)
				min_val = move2;
		}
		else {
			if(move < min_val)
				min_val = move;
		}

	}

}
