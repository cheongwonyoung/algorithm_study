package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_3055_탈출 {

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] dPosition = new int[2];
	static int[] sPosition = new int[2];
	static boolean[][] isCheck;
	static int R, C, cnt = 1;
	static int min_val = Integer.MAX_VALUE;
	static String[][] arr;
	static List<Integer[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<Integer[]>();
		String[] tem = in.readLine().split(" ");
		R = Integer.parseInt(tem[0]);
		C = Integer.parseInt(tem[1]);
		arr = new String[R][C];
		isCheck = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			tem = in.readLine().split("");
			for (int j = 0; j < C; j++) {
				arr[i][j] = tem[j];
				if (tem[j].equals("D")) {
					dPosition[0] = i;
					dPosition[1] = j;
				}
				if (tem[j].equals("S")) {
					sPosition[0] = i;
					sPosition[1] = j;
				}
				if (tem[j].equals("*")) {
					Integer[] t = { i, j };
					list.add(t);
				}
			}
		}

		bfs(dPosition[0], dPosition[1]);

		System.out.println(min_val);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<int[]>();

		int[] temp = { r, c };
		queue.add(temp);

		isCheck[r][c] = true;
		while (!queue.isEmpty()) {
			// 물 번지기 (돌, 고슴도치, 비버의 굴, 벽, 물로 번지기 x)
			// 물의 상황에 따라? 고슴도치 이동 체크?
			temp = queue.poll();
//			System.out.println(temp[0]);
//			System.out.println(temp[1]);
			for (Integer[] tme : list) {
				for (int j = 0; j < 4; j++) {
					int wr = tme[0] + dr[j];
					int wc = tme[1] + dc[j];
					if (wr < 0 || wr >= R || wc < 0 || wc >= C)
						continue;
					if (arr[wr][wc].equals("*") || arr[wr][wc].equals("X") || arr[wr][wc].equals("D")
							|| arr[wr][wc].equals("S"))
						continue;
					arr[wr][wc] = "*";
					Integer[] tt = { wr, wc };
					list.add(tt);

					for (int a = 0; a < R; a++) {
						for (int b = 0; b < C; b++) {
							System.out.print(arr[a][b] + " ");
						}
						System.out.println();
					}
				}
				// 고슴도치 이동
				for (int i = 0; i < 4; i++) {
					int nr = dr[i] + temp[0];
					int nc = dc[i] + temp[1];
//						System.out.println("wr = " + wr);
//						System.out.println("wc = " + wc);
//						System.out.println(nr);
//						System.out.println(nc);
					// 지도 범위
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					// 방문한 곳, 물과 돌
					if (!isCheck[temp[0]][temp[1]] || arr[nr][nc].equals("*") || arr[nr][nc].equals("X"))
						continue;

					// 이동

					// 도착시
					if (nr == sPosition[0] && nc == sPosition[1]) {
						if (cnt < min_val) {
							min_val = cnt;
							cnt = 0;
							System.out.println(min_val);
							break;
						}
					}

					// 다음 위치
					int[] e = new int[2];
					cnt += 1;
					e[0] = nr;
					e[1] = nc;
					isCheck[nr][nc] = true;
					queue.add(e);

				}
			}

		}

	}

}
