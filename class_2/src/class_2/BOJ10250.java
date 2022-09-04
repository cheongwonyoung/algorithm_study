package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BOJ10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t<=T; t++) {
			String[] tem = in.readLine().split(" ");
			int h = Integer.parseInt(tem[0]);
			int w = Integer.parseInt(tem[1]);
			int n = Integer.parseInt(tem[2]);
			
			int layer = n%h;
			int ho = n/h+1;
			
			if(layer==0) {
				sb.append(h*100+ho-1).append("\n");
			}
			else {
				sb.append(layer*100+ho).append("\n");
			}
			
		}
		System.out.println(sb);
		
	
		
		
	}
}
