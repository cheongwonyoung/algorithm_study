package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0; i<n; i++) {
			int val = Integer.parseInt(in.readLine());
			if(val == 0) {
				if(heap.isEmpty()) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(heap.poll()).append("\n");
				}
			}
			else {
				heap.add(val);
			}
		}
		System.out.println(sb);
		
	}
}
