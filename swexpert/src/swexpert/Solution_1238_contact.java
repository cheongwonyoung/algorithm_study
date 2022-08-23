package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1238_contact {
	
	static int[][] arr;
	static boolean[] check;
	static int[] size;
	static StringBuilder sb;
	static int max_size, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for(int T=1; T<=10; T++) {
			String[] temp = in.readLine().split(" ");
			int len = Integer.parseInt(temp[0]); // 데이터의 길이
			int start = Integer.parseInt(temp[1]); // 시작점
			
			arr = new int[101][101]; // 연락 인원
			temp = in.readLine().split(" ");
			
			for(int i=0; i<len-1; i+=2) {
				int from = Integer.parseInt(temp[i]);
				int to = Integer.parseInt(temp[i+1]);
				
				arr[from][to] = 1;
			}
			
			bfs(start);
			sb.append("#").append(T).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		result = 0;
		max_size = 0;
		check = new boolean[101];
		size = new int[101];
		check[start] = true;
		size[start] = 0;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			for(int i=0; i<101; i++) {
				if(arr[num][i]==1 && !(check[i])) {
					if(max_size < size[num]+1) {
						max_size = size[num]+1;
						result = i;
					}
					queue.add(i);
					check[i] = true;
					size[i] = size[num]+1;
					
					if(max_size==size[i] && result < i) result = i;
					
				}
			}
			
		}
		
		
		
		
	}
	
}













