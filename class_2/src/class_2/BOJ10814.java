package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ10814 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		
		String[][] arr = new String[n][2];
		
		for(int i=0; i<n; i++) {
			String[] tem = in.readLine().split(" ");
			arr[i][0] = tem[0];
			arr[i][1] = tem[1];
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
			
		});
		for(int i = 0; i<n; i++) {
//			System.out.println(arr[i][0] + " " + arr[i][1]);
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.println(sb);
	}
	
}
