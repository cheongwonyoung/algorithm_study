package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3124_최소스패닝트리 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			int result = 0;
			sb.append("#").append(t).append(" ");
			String[] tem = in.readLine().split(" ");
			int v = Integer.parseInt(tem[0]);
			int e = Integer.parseInt(tem[1]);
			int[] arr = new int[v+1];
			for(int i=0; i<=v; i++) {
				arr[i] = i;
			}
			
			for(int i=0; i<e; i++) {
				tem = in.readLine().split(" ");
				int a = Integer.parseInt(tem[0]);
				int b = Integer.parseInt(tem[1]);
				int c = Integer.parseInt(tem[2]);
				
				if(!(find(arr, a)==find(arr,b))) {
					result += c;
					union(arr, a, b);
				}
				
				
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	
		
	}
	
	public static void union(int[] arr, int a, int b) {
		a = find(arr, a);
		b = find(arr, b);
		
		if(a<b) {
			arr[b] = a;
		}
		else arr[a] = b;
	}
	
	public static int find(int[] arr, int n) {
		if(arr[n]==n) return n;
		else return find(arr, arr[n]);
	}
}
