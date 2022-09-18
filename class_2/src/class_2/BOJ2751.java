package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class BOJ2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i = 0; i<n; i++) {
			queue.offer(Integer.parseInt(in.readLine()));
		}
		
		for(int i = 0; i<n; i++) {
			sb.append(queue.poll()).append("\n");
		}
		System.out.println(sb);
	}
	
}
