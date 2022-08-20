package class_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2920 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int[] arr = new int[8];
		
		for(int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		boolean check = true;
		if(arr[0] == 1) {
			for(int i=0; i<7; i++) {
				if(arr[i]+1 != arr[i+1]) {
					System.out.println("mixed");
					check = false;
					break;
				}
			}
			if(check) System.out.println("ascending");
		}
		else if(arr[0] == 8) {
			for(int i=0; i<7; i++) {
				if(arr[i]-1 != arr[i+1]) {
					System.out.println("mixed");
					check = false;
					break;
				}	
			}
			if(check) System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
		
		
		
	}
	
}
