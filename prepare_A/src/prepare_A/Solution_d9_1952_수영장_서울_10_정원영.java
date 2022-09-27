package prepare_A;

import java.util.*;
import java.io.*;

public class Solution_d9_1952_수영장_서울_10_정원영 {
	static int min, pays[], days[];
	
	static void dfs(int idx, int sum) {
		if(idx>=12) {
			min = Math.min(sum, min);
			return;
		}
		dfs(idx+1, sum+days[idx]*pays[0]); // 1일
		dfs(idx+1, sum+pays[1]); // 1달
		dfs(idx+3, sum+pays[2]); // 3달
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_1952.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			pays = new int[4]; //1일,1달,3달,1년
			st=new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<4; i++) {
				pays[i] = Integer.parseInt(st.nextToken());
			}
			
			days = new int[12];
			st=new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			min=pays[3]; //1년권(제일 쌈)
			dfs(0,0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb.toString());
		in.close();
		
	}
}
