package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11660 {

	public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String[] temp = in.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]);
			
			int[] arr = new int[n*n];
			
			int cnt=0;
			for(int i=0; i<n; i++) {
				temp = in.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[cnt++] = Integer.parseInt(temp[j]);
				}
			}
			int sum = 0;
			for(int k=0; k<m; k++) {
				temp = in.readLine().split(" ");
				int x1 = Integer.parseInt(temp[0]);
				int y1 = Integer.parseInt(temp[1]);
				int x2 = Integer.parseInt(temp[2]);
				int y2 = Integer.parseInt(temp[3]);
				sum = 0;
				
				for(int l=n*(x1-1)+(y1-1); l<=n*(x2-1)+(y2-1); l++) {
					if(l%n < y1-1) continue;
					if(l%n > y2-1) continue;
					sum += arr[l];

				}
				sb.append(sum).append("\n");
				
			}
			System.out.println(sb);
			
		
			
	}

}
