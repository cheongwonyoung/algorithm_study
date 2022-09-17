package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int k  = Integer.parseInt(in.readLine());
		int sum = 0;
		
		for(int i = 0; i<k; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num==0) {
				if(!stack.isEmpty())
					stack.pop();
			}
			else {
				stack.add(num);
			}
		}
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
	
}
