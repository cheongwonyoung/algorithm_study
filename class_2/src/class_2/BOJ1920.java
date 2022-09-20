package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1920 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(in.readLine());
		String[] tem = in.readLine().split(" ");
		for(int i=0; i<n; i++) {			
			map.put(Integer.parseInt(tem[i]), 1);
		}

		int m = Integer.parseInt(in.readLine());
		tem = in.readLine().split(" ");
		for(int i=0; i<m; i++) {			
			if(map.containsKey(Integer.parseInt(tem[i]))) {
				sb.append(1).append("\n");
			}
			else {				
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
}
