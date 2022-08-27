package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10971_외판원순회2 {
	static int N, total;
	static int[][] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		visit = new boolean[N];

		total = Integer.MAX_VALUE;
		
		for(int i = 0; i<N; i++) {
			String[] tem = in.readLine().split(" ");
			for(int j = 0; j<N; j++) {
				arr[i][j] = Integer.parseInt(tem[j]);
			}
		}
		visit[0] = true;
		dfs(0,0,0);
		sb.append(total);
		System.out.println(sb);
	}
	
	public static void dfs(int cur, int cnt, int sum) {
		if(N-1==cnt) {
			if(arr[cur][0]!=0) {
				sum += arr[cur][0];
				if(sum < total) {
					total = sum;
				}
			}
			 
			return;
		}

		for(int i=0; i<N; i++) {
			if(visit[i] || arr[cur][i]==0) continue;
			visit[i] = true;
			dfs(i, cnt+1, sum+arr[cur][i]);
			visit[i] = false;
		}
		
	}
	
}
