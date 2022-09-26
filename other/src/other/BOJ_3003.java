package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2615 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int[] result = new int[6];
		int[] val = {1,1,2,2,2,8};
		
		// 1 1 2 2 2 8
		
		for(int i =0; i<6; i++) {
			result[i] = val[i]-Integer.parseInt(temp[i]);
		}
		for(int i = 0; i<6; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
}
