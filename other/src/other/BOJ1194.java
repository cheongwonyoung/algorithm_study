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
//	static HashMap<ing, int> map = new HashMap<int, int>();
	static List<Character> key_list;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tem = in.readLine().split(" ");
		n = Integer.parseInt(tem[0]);
		m = Integer.parseInt(tem[1]);
		
		arr = new char[n][m];
		
		start_i=0; 
		start_j=0;
		end_list = new ArrayList<>();
		key_list = new ArrayList<>();
		
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
		System.out.println(move);
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {i, j});
				
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			i = temp[0];
			j = temp[1];
			for(int l =0; l<end_list.size(); l++) {
				System.out.println("endlist");
				System.out.println(end_list.get(l)[0]);
				System.out.println(end_list.get(l)[1]);
			}
			
			
//			System.out.println("?");
			for(int d = 0; d <4; d++) {
				int nr = i + dr[d];
				int nc = j + dc[d];
				
				// 예외 범위 또는 벽(이동 x)
				if(nr<0 || nc<0 || nr>=n || nc>=m || arr[nr][nc]=='#') continue;
				
				// 문인데 키가 없으면(이동 x)
				else if((arr[nr][nc]-0 >=65 && arr[nr][nc]-0<=70) && !key_list.contains(arr[nr][nc])) 
					continue;
				
				// 키 추가 (이동 o)
				else if(!key_list.contains('A') && arr[nr][nc]=='a') {
					arr[nr][nc] = '.';
					key_list.add('A');
				}else if(!key_list.contains('B') &&arr[nr][nc]=='b') {
					arr[nr][nc] = '.';
					key_list.add('B');
				}else if(!key_list.contains('C') &&arr[nr][nc]=='c') {
					arr[nr][nc] = '.';
					key_list.add('C');
				}else if(!key_list.contains('D') &&arr[nr][nc]=='d') {
					arr[nr][nc] = '.';
					key_list.add('D');
				}else if(!key_list.contains('E') &&arr[nr][nc]=='e') {
					arr[nr][nc] = '.';
					key_list.add('E');
				}else if(!key_list.contains('F') &&arr[nr][nc]=='f') {
					arr[nr][nc] = '.';
					key_list.add('F');
				}
				
				queue.offer(new int[] {nr,nc});
				move += 1;
				
			}
		}
		
	}
	
}











