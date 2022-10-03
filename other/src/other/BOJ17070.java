package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ17070 {
	static int[][] arr;
	static int n;
<<<<<<< HEAD
	static int total; 
=======
	static int total;
>>>>>>> 0d7306307e359bae0e9157f7083b07836cb6409b

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] temp = in.readLine().split(" ");
			for(int j =0; j<n; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		System.out.println(bfs(0,1));
		
		
	}
	
	public static int bfs(int i, int j) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j,0});
//		boolean[][] check = new boolean[n][n];
//		check[i][j]=true;
		int state = 0; // 0: 가로, 1:세로, 2:대각
		
		while(!queue.isEmpty()) {
			int[] tem = queue.poll();
			i = tem[0];
			j = tem[1];
			state = tem[2];
//			check[i][j] = true;
//			System.out.println(i+" " + j);
//			System.out.println(state);
			if(i==n-1 && j==n-1) {
				total++;
//				System.out.println();
				continue;
			}
			
			// 가로 이동
			if(state!=1 && i<n && j+1<n && arr[i][j+1]==0) {

				queue.add(new int[] {i, j+1, 0});

			}
			// 세로 이동
			if(state!=0 && i+1<n && j<n && arr[i+1][j]==0 ) {

				queue.add(new int[] {i+1, j, 1});
			}
			// 대각 이동
			if(i+1<n && j+1<n && arr[i+1][j+1]==0 && arr[i][j+1]==0 && arr[i+1][j]==0 ) {

				queue.add(new int[] {i+1, j+1, 2});
			}
			
		}
		
		
		return total;
		
	}
}
