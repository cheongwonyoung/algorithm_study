package prepare_A;

import java.util.*;
import java.io.*;

public class Solution_d9_1952_수영장_서울_10_정원영2 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_1952.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			int[] pays = new int[4]; //1일,1달,3달,1년
			st=new StringTokenizer(in.readLine(), " ");
			for(int i=0; i<4; i++) {
				pays[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] days = new int[12+1];
			st=new StringTokenizer(in.readLine(), " ");
			for(int i=1; i<=12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[12+1];
			for(int i=1; i<=12; i++) {
				int DAY = dp[i-1] + pays[0]*days[i]; // 1일
				int MONTH=dp[i-1] + pays[1]; // 1달
				int MONT3=(i>=3)? dp[i-3]+pays[2]:Integer.MAX_VALUE;//3달
				int YEAR=(i==12)? 		pays[3]:Integer.MAX_VALUE; //1년
				dp[i]=Math.min(DAY,  Math.min(MONTH, Math.min(MONT3, YEAR)));
			}
			sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
			
		}
		System.out.println(sb.toString());
		in.close();
		
	}
}
