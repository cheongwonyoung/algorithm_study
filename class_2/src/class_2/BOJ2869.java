package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ2869 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());

		String[] arr = new String[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = in.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				else{
					return o1.length()-o2.length();
				}
			}
			
		});
		
		sb.append(arr[0]).append("\n");
		
		for(int i=1; i<n; i++) {
			if(arr[i].equals(arr[i-1])) {
				continue;
			}
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
