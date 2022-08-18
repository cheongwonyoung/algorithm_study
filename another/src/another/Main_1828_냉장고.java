package another;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1828_냉장고 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][2];
		String[] temp;
		int cnt = 1;
		
		for(int i=0; i<n; i++) {
			temp = in.readLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
				
			}
			
			
		});
		
		int max_val = arr[0][1];
		
		for(int j=1; j<n; j++) {
			if(max_val < arr[j][0]) {
				cnt++;
				max_val = arr[j][1];
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
