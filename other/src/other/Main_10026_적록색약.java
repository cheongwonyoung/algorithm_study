package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10026_적록색약 {
	static int n, cnt;
	static String[][] arr1;
	static String[][] arr2;
	static boolean[][] check;
	//상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr1 = new String[n][n];
		arr2 = new String[n][n];
		
		check = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String[] tem = in.readLine().split("");
			for(int j=0; j<n; j++) {
				arr1[i][j] = tem[j];
				arr2[i][j] = tem[j];
				if(tem[j].equals("R")) {
					arr2[i][j] = "G";
				}
			}
		}
		
		bfs(arr1);
		System.out.print(cnt + " ");
		cnt = 0;
		check = new boolean[n][n];
		bfs(arr2);
		System.out.println(cnt);
		
		
	}
	
	public static void bfs(String[][] arr) {

		for(int j =0; j<n; j++) {
			for(int k =0; k<n; k++) {
				if(!check[j][k]) {
					Queue<int[]> queue = new ArrayDeque<int[]>();
					queue.add(new int[] {j,k});
					check[j][k] = true;
					
					while(!queue.isEmpty()) {
						int[] temp = queue.poll();
						int row = temp[0];
						int col = temp[1];
						
						for(int i =0; i<4; i++) {
							int nr = row + dr[i];
							int nc = col + dc[i];
							
							if(nr<0 || nr>=n || nc <0 || nc>=n ) continue;
							if(check[nr][nc] || !(arr[nr][nc].equals(arr[row][col]))) continue;
							
							queue.add(new int[] {nr,nc});
							check[nr][nc] = true;
						}
					}

					cnt++;
				}
			}
		}
		
		
		
	}
	
}












