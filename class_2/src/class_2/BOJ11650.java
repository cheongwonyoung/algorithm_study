package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			String[] tem = in.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tem[0]);
			arr[i][1] = Integer.parseInt(tem[1]);
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}
				else {					
					return o1[0]-o2[0];
				}
			}
		});
		
		
		for(int i =0; i<n; i++) {
			for(int j=0; j<2; j++) {
				sb.append(arr[i][j]).append(" ");
				
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
