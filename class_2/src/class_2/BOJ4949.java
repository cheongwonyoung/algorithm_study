package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = {""};
		while(true) {
			boolean check = true;
			Stack<String> stack = new Stack<>();
			temp = in.readLine().split("");
			if(temp[0].equals(".")) break;
			int len = temp.length;
			for(int i = 0; i<len; i++) {
				if(temp[i].equals("(") || temp[i].equals("[")) {
					stack.add(temp[i]);
				}
				else if(temp[i].equals(")") || temp[i].equals("]")) {
					if(stack.isEmpty()) {
						System.out.println("no");
						check = false;
						break;
					}
					else if(temp[i].equals(")")) {
						if(!stack.pop().equals("(")){
							System.out.println("no");
							check = false;
							break;
						}
					}
					else if(temp[i].equals("]")) {
						if(!stack.pop().equals("[")){
							System.out.println("no");
							check = false;
							break;
						}
					}
				}
			}
			if(stack.isEmpty() && check) {
				System.out.println("yes");
			}
			else if(check){
				System.out.println("no");
			}
			
		}
		
	}
	
}
