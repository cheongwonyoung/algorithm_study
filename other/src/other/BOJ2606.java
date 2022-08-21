package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2606 {
	
	static boolean[] check;
	static int[][] arr;
	static int n, m, cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		arr = new int[n+1][n+1];
		
		for(int i=1; i<=m; i++) {
			String[] temp = in.readLine().split(" ");
			int n1 = Integer.parseInt(temp[0]); 
			int n2 = Integer.parseInt(temp[1]);
			arr[n1][n2] = arr[n2][n1] = 1;
		}
		check = new boolean[n+1];
		bfs();
		System.out.println(cnt-1);
		
	}
	
	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1);
		check[1] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			cnt+=1;
			
			for(int i=1; i<=n; i++) {
				if(!check[i] && arr[num][i]!=0) {
					queue.offer(i);
					check[i] = true;
				}
			}
		}
	}
	
}
