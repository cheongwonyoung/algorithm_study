package prepare_A;

import java.io.*;
import java.util.*;

public class Solution_d9_4008_숫자만들기_서울_10_정원영2 {
	static int N, o[], a[], min, max;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N=Integer.parseInt(st.nextToken());
			o=new int[4];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i =0; i<4; i++) o[i]=Integer.parseInt(st.nextToken()); 
			a=new int[N];
			for(int i =0; i<N; i++) a[i]=Integer.parseInt(st.nextToken());
			min=100_000_000; max=-100_000_000;
			//
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
			
		}
		System.out.println(sb.toString());
		br.close();
	}
	
}
