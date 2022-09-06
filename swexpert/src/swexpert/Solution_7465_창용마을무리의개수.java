package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_7465_창용마을무리의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t<=T; t++) {
			Set<Integer> set = new HashSet<>();
			String[] temp = in.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]);
			int[] arr = new int[n+1]; // 마을 사람
			
			for(int i=0; i<=n; i++) {
				arr[i] = i;
			}
			
			for(int i=0; i<m; i++) {
				temp = in.readLine().split(" ");
				int a = Integer.parseInt(temp[0]);
				int b = Integer.parseInt(temp[1]);
				
				if(!(find(arr, a)==find(arr, b))) {
					union(arr, a, b);
				}
				
			}
			
			for(int i = 0; i<n+1; i++) {

				set.add(find(arr, arr[i]));
			}
			sb.append("#").append(t).append(" ").append(set.size()-1).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int find(int[] arr, int n) {
		if(arr[n]==n) return arr[n];
		else return arr[n] = find(arr, arr[n]);
	}
	
	public static void union(int[] arr, int a, int b) {
		a = find(arr, a);
		b = find(arr, b);
		if(a>b) {
			arr[a] =b;
		
		}
		else {
			arr[b] =a;
		}
	}
	
}







