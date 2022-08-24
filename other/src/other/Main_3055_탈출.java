package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main_3055_탈출 {

	static int r;
	static int c;
	static String[][] arr;
	static List<int[]> list;
	static int[] start, end;
	static int cnt; // 범람횟수
	static int[][] check; // 몇 분인지
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		r = Integer.parseInt(tem[0]);
		c = Integer.parseInt(tem[1]);
		arr = new String[r][c];
		check = new int[r][c];
		list = new ArrayList<>(); // 물 위치
		start = new int[2]; //
		end = new int[2];

		for (int i = 0; i < r; i++) {
			tem = in.readLine().split("");
			for (int j = 0; j < c; j++) {
				arr[i][j] = tem[j];
				if (arr[i][j].equals("D")) {
					end[0] = i;
					end[1] = j;
				}
				if (arr[i][j].equals("S")) {
					start[0] = i;
					start[1] = j;
				}
				if (arr[i][j].equals("*")) {
					list.add(new int[] { i, j });
				}
			}
		}

		for(int i =0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void bfs() {
		Queue<Integer[]> queue = new ArrayDeque<>();
		// 물 확산
		int len = list.size();
		for (int i=0; i<len; i++) {
			int row = list.get(i)[0];
			int col = list.get(i)[1];
			for (int j = 0; j < 4; j++) {
				int nr = dr[j] + row;
				int nc = dc[j] + col;

				if (nr < 0 || nr >= r || nc < 0 || nc >= c)
					continue;
				if(arr[nr][nc].equals("X") || arr[nr][nc].equals("*")||arr[nr][nc].equals("D") || arr[nr][nc].equals("S")  )
					continue;
				arr[nr][nc] = "*";
				list.add(new int[] {nr, nc});
			}
		}
		
		queue.add(new Integer[] { start[0], start[1] });
		check[start[0]][start[1]] = 0;

		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			int row = temp[0];
			int col = temp[1];
			
			// 물 확산
			if((cnt++)==check[row][col]) {
				
				len = list.size();
				for (int i=0; i<len; i++) {
					int ro = list.get(i)[0];
					int co = list.get(i)[1];
					for (int j = 0; j < 4; j++) {
						int nr = dr[j] + ro;
						int nc = dc[j] + co;
						
						if (nr < 0 || nr >= r || nc < 0 || nc >= c)
							continue;
						
						if(arr[nr][nc].equals("X") || arr[nr][nc].equals("*")||arr[nr][nc].equals("D") || arr[nr][nc].equals("S")  )
							continue;
						
						arr[nr][nc] = "*";
						list.add(new int[] {nr, nc});
					}
				}
				
			}
			
			// 이동
			for(int i =0; i<4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if (nr < 0 || nr >= r || nc < 0 || nc >= c)
					continue;
				
				if(arr[nr][nc].equals("X") || arr[nr][nc].equals("*") || arr[nr][nc].equals("S")) continue;
			
				queue.add(new Integer[] {nr, nc});
				check[nr][nc] = check[row][col] + 1;
			}	
			
		}

	}

}
