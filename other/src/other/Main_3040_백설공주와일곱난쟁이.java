package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_3040_백설공주와일곱난쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[9];
		int sum = 0;
		int pass_num1=0;
		int pass_num2=0;
		
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-arr[i]-arr[j] == 100) {
					pass_num1 = i;
					pass_num2 = j;
					break;
				}
			}
		}
		
		for(int i =0; i<9; i++) {
			if(i==pass_num1 || i==pass_num2) {
				continue;
			}
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
