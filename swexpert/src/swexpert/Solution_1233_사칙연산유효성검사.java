package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1233_사칙연산유효성검사 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=10; i++) {
			int res = 1;
			String tem = in.readLine();

			int n = Integer.parseInt(tem);
			for(int j=1; j<=n; j++) {

				String[] temp = in.readLine().split(" ");

				if(temp.length==4 && !(temp[1].equals("+") || temp[1].equals("-") || temp[1].equals("/") || temp[1].equals("*"))) {
					res = 0;
					while(true) {
						in.readLine();
						j++;
						if(j==n) break;
					}
				}
				else if(temp.length==2 && (temp[1]=="+" || temp[1]=="-" || temp[1]=="*" || temp[1]=="/")  ) {
					res = 0;
					while(true) {
						in.readLine();
						j++;
						if(j==n) break;
					}
				}
			}
			sb.append("#").append(i).append(" ").append(res).append("\n");
			
		}
		System.out.println(sb);

	}
	
}
