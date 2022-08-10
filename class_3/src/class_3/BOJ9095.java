package class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		int tc = Integer.parseInt(in.readLine());
		int max_val = Integer.MIN_VALUE;
		for (int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(in.readLine());
			list.add(n);
			if(max_val < n) {
				max_val = n;
			}
		}
		int[] arr = new int[max_val + 1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int j=4; j<=max_val; j++) {
			arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
		}
		for(int k=0; k<list.size(); k++) {
			sb.append(arr[list.get(k)]).append("\n");
		}
		
		System.out.println(sb);

	}

}
