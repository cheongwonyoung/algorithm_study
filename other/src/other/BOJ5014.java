package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ5014 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		int F = Integer.parseInt(tem[0]);
		int S = Integer.parseInt(tem[1]);
		int G = Integer.parseInt(tem[2]);
		int U = Integer.parseInt(tem[3]);
		int D = Integer.parseInt(tem[4]);

	
		bfs(F, S, G, U, D, 0);
		
	}

	private static void bfs(int f, int s, int g, int u, int d, int c) {
		ArrayDeque<int []> queue = new ArrayDeque<>();
		boolean[] arr = new boolean[f+1];
		queue.add(new int[] {s, 0});
		arr[s] = true;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int cur = temp[0];
			int cnt = temp[1];
			
			if(cur == g) {
				System.out.println(cnt);
				return;
			}
			
			if(cur + u <= f && !arr[cur+u]) {
				queue.offer(new int[] {cur+u, cnt+1});
				arr[cur+u] = true;
			
			}
			if(cur - d > 0 && !arr[cur-d]) {
				queue.offer(new int[] {cur-d, cnt+1});
				arr[cur-d] = true;
			}
			
		}
		System.out.println("use the stairs");
		
		return;
		
	}

}
