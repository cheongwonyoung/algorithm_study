package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class BOJ10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int n = Integer.parseInt(in.readLine());
		
		for(int i = 0; i<n; i++) {
			String[] tem = in.readLine().split(" ");
			if(tem[0].equals("push")) {
				queue.add(Integer.parseInt(tem[1]));
			}
			else if(tem[0].equals("pop")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					
					sb.append(queue.poll()).append("\n");
				}
			}
			else if(tem[0].equals("size")) {
				sb.append(queue.size()).append("\n");
			}
			else if(tem[0].equals("empty")) {
				if(queue.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(tem[0].equals("front")) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
					continue;
				}
				else {
					sb.append(queue.getFirst()).append("\n");
				}
			}
			else if(tem[0].equals("back")) {
				if(queue.isEmpty()) {
					
					sb.append(-1).append("\n");
					continue;
				}
				else {
					sb.append(queue.getLast()).append("\n");
				}
			}
			
		}
		System.out.println(sb);
	}
	
}
