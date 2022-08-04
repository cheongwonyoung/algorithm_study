package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=10; i++) {
			sb.append("#").append(i).append(" ");
			Deque<String> deque = new ArrayDeque<String>();
			int tl = Integer.parseInt(in.readLine()); 
			String[] tc = in.readLine().split("");

			int result = 1;
			for(int j=0; j<tl; j++) {
				if(tc[j].equals("(") || tc[j].equals("[") || tc[j].equals("{") || tc[j].equals("<")) {
					deque.addLast(tc[j]);
				}
				else {
					String temp = deque.pollLast();
					if(temp.equals("(") && tc[j].equals(")")) {
						continue;
					}
					else if(temp.equals("{") && tc[j].equals("}")) {
						continue;
					}
					else if(temp.equals("[") && tc[j].equals("]")) {
						continue;
					}
					else if(temp.equals("<") && tc[j].equals(">")) {
						continue;
					}
					else {

						result = 0;
						break;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		
	}
	
}
