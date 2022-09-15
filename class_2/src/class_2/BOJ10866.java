package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10866 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		int N = Integer.parseInt(in.readLine());
		
		for(int i=0; i<N; i++) {
			String[] tem = in.readLine().split(" ");
			if(tem[0].equals("push_front")) {
				deque.offerFirst(Integer.parseInt(tem[1]));
			}
			else if(tem[0].equals("push_back")) {
				deque.offerLast(Integer.parseInt(tem[1]));
			}
			else if(tem[0].equals("pop_front")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.pollFirst()).append("\n");
				}
			}
			else if(tem[0].equals("pop_back")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.pollLast()).append("\n");
				}
			}
			else if(tem[0].equals("size")) {
				sb.append(deque.size()).append("\n");
			}
			else if(tem[0].equals("empty")) {
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			else if(tem[0].equals("front")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.getFirst()).append("\n");
				}
			}
			else if(tem[0].equals("back")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {					
					sb.append(deque.getLast()).append("\n");
				}
			}

		}
		System.out.println(sb);
	}
	
	
}
