package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		
		for(int i =0; i<n; i++) {
			boolean check = true;
			Stack<String> stack = new Stack<>();
			String[] temp = in.readLine().split("");
			int len = temp.length;
			for(int j=0; j<len; j++) {
				if(temp[j].equals("(")) {
					stack.add("(");
				}
				else {
					if(stack.isEmpty()) {
						check = false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			if(!stack.isEmpty()) check = false;
			if(check) {
				sb.append("YES").append("\n");
//				System.out.println("YES");
			}
			else {
				sb.append("NO").append("\n");
//				System.out.println("NO");
			}
		}
		System.out.println(sb);
	}
	
}
