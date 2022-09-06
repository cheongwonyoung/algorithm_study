package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_3124_최소스패닝트리 {
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			long result = 0;
			PriorityQueue<Edge> queue = new PriorityQueue<>();
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
				
				queue.add(new Edge(a,b,c));
			}
			int len = queue.size();
			for(int i=0; i<len; i++) {
				Edge temp = queue.poll();
				if(!(find(arr, temp.a)==find(arr,temp.b))) {
					result += temp.c;
					union(arr, temp.a, temp.b);
				}
				
			}
				
				
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}		System.out.println(sb);
	
		
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
		else return arr[n] = find(arr, arr[n]);
	}
}
