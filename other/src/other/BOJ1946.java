package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(in.readLine());
			int cnt = 1;
//			int[][] arr = new int[n][2];
			int[] arr = new int[n+1];
			for(int i=0; i<n; i++) {
				String[] tem = in.readLine().split(" ");
				int t1 = Integer.parseInt(tem[0]);
				int t2 = Integer.parseInt(tem[1]);
				arr[t1] = t2;
			}
			
			int start = arr[1];
			for(int i=2; i<n+1; i++) {
				if(start > arr[i]) {
					cnt++;
					start = arr[i];
				}
				

				
			}
			
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
	}
	
}
