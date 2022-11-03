package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class BOJ15903 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> queue = new PriorityQueue<>();
		String[] tem = in.readLine().split(" ");
		
		int n = Integer.parseInt(tem[0]); // 카드의 개수
		int m = Integer.parseInt(tem[1]); // 카드 합체 횟수
		tem = in.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			queue.offer(Long.parseLong(tem[i]));
		}
		
		for(int i=0; i<m; i++) {
			Long q1 = queue.poll();
			Long q2 = queue.poll();
			Long sum = q1+q2;
			queue.offer(sum);
			queue.offer(sum);
			
		}
		
		long result = 0;
		for(int i=0; i<n; i++) {
			result += queue.poll();	
		}
		System.out.println(result);
	}
	
}
