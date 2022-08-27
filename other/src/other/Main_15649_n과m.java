package other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_15649_n과m {
	
	static int n; 
	static int m; 
	static boolean[] visited; 
	static int[] result;
	static int cnt;
//	static StringBuilder sb;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		sb = new StringBuilder();
		String[] tem = in.readLine().split(" ");
		n = Integer.parseInt(tem[0]); 
		m = Integer.parseInt(tem[1]);
		visited = new boolean[n+1];
		result = new int[m];
		per(0);
//		System.out.print(sb);
		bw.flush(); // stack에 누적된 명령(append)들을 한번에 실행
		bw.close();
		
	}
	
	public static void per(int start) throws IOException {
			if(m==start) {
				for(int temp : result) {
//					sb.append(temp).append(" ");
					bw.append(Integer.toString(temp));
					bw.append(" ");
				}
//				sb.append("\n");
				bw.append("\n");
				return;
			}
			
			for(int i=1; i<=n; i++) {
				if(visited[i]) continue;
				
				result[start] = i;
				visited[i] = true;
				per(start+1);
				visited[i] = false;
				
			}
	}
	
}
