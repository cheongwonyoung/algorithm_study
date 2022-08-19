package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ1260 {
	static int[][] arr; 
	static boolean[] check; 
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]); // 정점의 개수
		int m = Integer.parseInt(temp[1]); // 간선의 개수
		int v = Integer.parseInt(temp[2]); // 정점의 번호
		
		arr = new int[n+1][n+1]; 
		check = new boolean[n+1]; 
		
		for(int i=0; i<m; i++) {
			temp = in.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			
			arr[start][end] = arr[end][start] = 1;
		}

		dfs(v);
		System.out.println();
		bfs(v);
	}
	
	public static void dfs(int cur) {
		check[cur] = true;
		System.out.print(cur + " ");
		
		for(int i=1; i<=n; i++) {
			if(!check[i] && arr[cur][i]!=0) {
				
				dfs(i); 
				
			}
		}

	}
	
	public static void bfs(int cur) {
		Queue<Integer> list = new ArrayDeque<>();
		check = new boolean[n+1]; 
		check[cur] = true;
		list.add(cur);
		
		while(!list.isEmpty()) {
			int tem = list.poll();
			System.out.print(tem + " ");
			
			for(int i=1; i<=n; i++) {
				if(!check[i] && arr[tem][i]!=0) {
					check[i]=true;
					list.add(i);
				}
			}
		}
		
	}
	
}












