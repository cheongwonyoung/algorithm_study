package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main_1997_최소스패닝트리 {
	
	public static class Edge implements Comparable<Edge>{

		int a, b, c;
		
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] tem =  in.readLine().split(" ");
		int v= Integer.parseInt(tem[0]);
		int e= Integer.parseInt(tem[1]);
		
//		PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
//			@Override
//			public int compare(Edge o1, Edge o2) {
//				return o1.c-o2.c;
//			}
//		});
		
		List<Edge> queue = new ArrayList<Edge>();
		int[] arr = new int[v+1];
		int result = 0;
		for(int i = 0; i<=v; i++) {
			arr[i] = i;
		}

		for(int i = 0; i<e; i++) {
			tem = in.readLine().split(" ");
			int a = Integer.parseInt(tem[0]);
			int b = Integer.parseInt(tem[1]);
			int c = Integer.parseInt(tem[2]);
			
			queue.add(new Edge(a,b,c));	
			
		}
		Collections.sort(queue);
		for(Edge temp : queue) {
//			System.out.println(temp.c);
			if(find(arr, temp.a) == find(arr, temp.b)) continue;
			union(arr, temp.a, temp.b);
			result += temp.c;
		}

		sb.append(result);
		System.out.println(result);
	}
	
	public static int find(int[] arr, int n) {
		if(arr[n]==n) return n;
		else return arr[n]=find(arr, arr[n]);
	}
	
	public static void union(int[] arr, int a, int b) {
		a = find(arr, a); 
		b = find(arr, b); 
		if(a < b) {
			arr[b] = a;
		}
		else {
			arr[a] = b;
		}
	}
	
	
	
}










