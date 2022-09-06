package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			String[] tem = in.readLine().split(" ");
			
			if(tem[0].equals("push")) {
				stack.push(Integer.parseInt(tem[1]));
			}
			else if(tem[0].equals("pop")) {
				if(stack.empty()) {
					sb.append(-1).append("\n");
					continue;
				}
				sb.append(stack.pop()).append("\n");
			}
			else if(tem[0].equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			else if(tem[0].equals("empty")) {
				if(stack.empty()) {
					sb.append(1).append("\n");
				}
				else 
					sb.append(0).append("\n");
			}
			else if(tem[0].equals("top")) {
				if(!stack.empty()) {
					sb.append(stack.peek()).append("\n");					
				}
				else
					sb.append(-1).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
