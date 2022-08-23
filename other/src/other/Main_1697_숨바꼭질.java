package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_1697_숨바꼭질 {
	static int k;
<<<<<<< HEAD
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

=======
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		
		bfs(n);
>>>>>>> 16e6365bf397baeaf8bae84fbd50ef60bb9101dd
	}
	
	public static void bfs(int n) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
<<<<<<< HEAD
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











=======
		boolean[] visit = new boolean[100001];
		int[] check = new int[100001];
		queue.add(n);
		check[n] = 0;
		visit[n] = true;
		while(!queue.isEmpty()){
			int tem = queue.poll();
			
			if(tem==k) {
				System.out.println(check[tem]);
				break;
			}
			if(tem-1 >= 0 && tem-1 <=100000 && visit[tem-1]==false)
			{
				queue.add(tem-1);
				visit[tem-1] = true;
				check[tem-1] = check[tem]+1;
			}
			if(tem+1 >= 0 && tem+1 <=100000 && visit[tem+1]==false)
			{
				queue.add(tem+1);
				visit[tem+1] = true;
				check[tem+1] = check[tem]+1;
				}
			if(tem*2 >= 0 && tem*2 <=100000 && visit[tem*2]==false)
			{
				queue.add(tem*2);
				visit[tem*2] = true;
				check[tem*2] = check[tem]+1;
			}
		}
	}
	
}
>>>>>>> 16e6365bf397baeaf8bae84fbd50ef60bb9101dd
