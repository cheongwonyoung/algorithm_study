package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		String[] tem = in.readLine().split(" ");
		int n = Integer.parseInt(tem[0]);
		int k = Integer.parseInt(tem[1]);
		
		for(int i = 1; i<=n; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		
		while(!queue.isEmpty()) {
			for(int i = 0; i<k-1; i++) {
				queue.offer(queue.poll());
			}
			if(queue.size()==1) {
				sb.append(queue.poll());
			}
			else {				
				sb.append(queue.poll()).append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}
	
}
