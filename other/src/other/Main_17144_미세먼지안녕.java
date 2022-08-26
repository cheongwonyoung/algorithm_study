package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17144_미세먼지안녕 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");

		int r = Integer.parseInt(tem[0]);
		int c = Integer.parseInt(tem[1]);
		int t = Integer.parseInt(tem[2]);
		int total = 0;
		
		// 상하좌우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int air = 0; // 두번째 공기청정기의 행위치

		
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			tem = in.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);

				// 두번째 공기청정기 위치
				if (arr[i][j] == -1) {
					air = i;
				}
			}
		}

		// 1초동안 일어나는 상황
		for (int T = 0; T < t; T++) {
			int[][] result = new int[r][c];
			// 1. 미세먼지 확산
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					// 없거나 공기청정기면 패스
					if (arr[i][j] == 0 || arr[i][j] == -1)
						continue;

					// 미세먼지면
					else {
						int len = 0; // 확산된 방향의 개수
						for (int k = 0; k < 4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];

							// 칸이 없거나 공기청정기가 있으면 패스
							if (nr < 0 || nr >= r || nc < 0 || nc >= c || arr[nr][nc] == -1)
								continue;

							result[nr][nc] += arr[i][j] / 5;
							len++;
						}
						// (r,c)에 남은미세먼지 양
						result[i][j] += arr[i][j] - arr[i][j] / 5 * len;

					}

				}
			}

			// 재반영
			arr = result;
			for(int i = 0; i<r; i++) {
				for(int j=0; j<c; j++) {
					arr[i][j] = result[i][j];
				}
			}

			// 2. 공기청정기 순환

			// 위 청정기
			int row = air - 1; // 첫번째 공기청정기 row
			int col = 0;

			// 상
			while (true) {
				if (row - 2 < 0) {
					row = 0;
					break;
				}
				arr[row - 1][col] = arr[row - 2][col];
				row -= 1;
			}
			// 우
			while (true) {
				if(col+1>=c) {
					break;
				}
				
				arr[row][col] = arr[row][col+1];
				col += 1;
			}
			// 하
			while (true) {
				if (row +1 > air-1)
					break;
				arr[row][col] = arr[row+1][col];
				row+=1;
			}
			// 좌
			while (true) {
				if (col - 1 <= 0) {					
					arr[row][col] = 0;
					break;
				}
				arr[row][col] = arr[row][col-1];
				col -= 1;
			}

			// 아래 청정기
			
			row = air; // 두번째 공기청정기 row
			col = 0;

			// 하
			while (true) {
				if (row +1 >= r)
					break;
				arr[row][col] = arr[row+1][col];
				row+=1;
			}
			// 우
			while (true) {
				if(col+1>=c) {
					break;
				}
				
				arr[row][col] = arr[row][col+1];
				col += 1;
			}
			// 상
			while (true) {
				if (row - 1 < air) {
					break;
				}
				arr[row][col] = arr[row - 1][col];
				row -= 1;
			}
			// 좌
			while (true) {
				if (col - 1 <= 0) {					
					arr[row][col] = 0;
					break;
				}
				arr[row][col] = arr[row][col-1];
				col -= 1;
			}
			
			// 공기청정기 재배치
			arr[air-1][0] = -1;
			arr[air][0] = -1;
			
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				total += arr[i][j];
			}

		}
		total += 2;
		System.out.println(total);
	}
}
