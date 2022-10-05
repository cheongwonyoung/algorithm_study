package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BOJ1194 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n, m, move, start_i, start_j;
	static List<int[]> end_list;
	static List<Character> key_list;
	static Character[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tem = in.readLine().split(" ");
		n = Integer.parseInt(tem[0]);
		m = Integer.parseInt(tem[1]);
		
		arr = new Character[n][m];
		
		start_i=0; 
		start_j=0;
		end_list = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			tem = in.readLine().split("");
			for(int j=0; j<m; j++) {
				arr[i][j] = tem[j].charAt(0);
				
				if(tem[j].equals("0")) {
					start_i = i;
					start_j = j;
				}
				else if(tem[j].equals("1")) {
					end_list.add(new int[] {i,j});
				}
				
			}
		}
		
		bfs(start_i, start_j);
//		System.out.println('A'-0);
//		System.out.println('F'-0);
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		move = -1;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			i = temp[0];
			j = temp[1];
			
			for(int d = 0; d <4; d++) {
				int nr = i + dr[d];
				int nc = j + dc[d];
				
				// 예외 범위 또는 벽(이동 x)
				if(nr<0 || nc<0 || nr>=n || nc>=m || arr[nr][nc].equals('#')) continue;
				
				// 문인데 키가 없으면(이동 x)
				else if((arr[nr][nc]-0 >=65 && arr[nr][nc]-0<=70) && !key_list.contains(arr[nr][nc])) 
					continue;
				
				// 키 추가 (이동 o)
				else if(arr[nr][nc].equals('a')) {
					arr[nr][nc] = '.';
					key_list.add('A');
				}else if(arr[nr][nc].equals('b')) {
					arr[nr][nc] = '.';
					key_list.add('B');
				}else if(arr[nr][nc].equals('c')) {
					arr[nr][nc] = '.';
					key_list.add('C');
				}else if(arr[nr][nc].equals('d')) {
					arr[nr][nc] = '.';
					key_list.add('D');
				}else if(arr[nr][nc].equals('e')) {
					arr[nr][nc] = '.';
					key_list.add('E');
				}else if(arr[nr][nc].equals('f')) {
					arr[nr][nc] = '.';
					key_list.add('F');
				}
				
				queue.offer(new int[] {nr,nc});
				if()
				move += 1;
				
			}
		}
		
	}
	
}











