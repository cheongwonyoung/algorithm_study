package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_1697_숨바꼭질 {
	static int k;
	static int result = Integer.MAX_VALUE;
	static boolean[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		cnt = 0;
//		arr = new boolean[100000];
		bfs(n);

	}
	
	public static void bfs(int n) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(n);
//		arr[n] = true;
		
		while(!queue.isEmpty()) {
			
			int temp = queue.poll();
			cnt++;
			if(temp==k) {
				System.out.println(cnt);
				break;
			}
//			System.out.println(temp);
			
//			if(!arr[temp-1]) {
				queue.offer(temp-1);
//				arr[temp-1] = true;
//			}
//			if(!arr[temp+1]) {
				queue.offer(temp+1);
//				arr[temp+1] = true;
//			}
//			if(!arr[temp*2]) {
				queue.offer(temp*2);
//				arr[temp*2] = true;
//			}
			
			
		}
		
	}
	
}











