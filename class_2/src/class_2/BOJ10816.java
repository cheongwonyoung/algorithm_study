package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(in.readLine());

		String temp[] = in.readLine().split(" ");
		for(int i=0; i<n; i++) {
			int tem = Integer.parseInt(temp[i]);
			if(map.containsKey(tem)) {				
				map.put(tem, map.get(tem)+1);
			}
			else {
				map.put(tem, 1);
			}
		}
		
		int m = Integer.parseInt(in.readLine());
		temp = in.readLine().split(" ");
		for(int i =0; i<m; i++) {
			int tem = Integer.parseInt(temp[i]);
			if(map.containsKey(tem)) {
				sb.append(map.get(tem)).append(" ");
			}
			else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
	
}
