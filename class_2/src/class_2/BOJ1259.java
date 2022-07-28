package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1259 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		int len = 0;
		String[] arr;
		boolean temp;
		do {
			
			temp = true;
			arr = in.readLine().split("");
			num = Integer.parseInt(arr[0]);
			if(num==0) break;
			len = arr.length;
			String[] temp_arr = new String[len];
			for(int i=0; i<len; i++) {
				temp_arr[i] = arr[len-1-i];
			}
			for(int i=0; i<len; i++) {
				if(!(temp_arr[i].equals(arr[i]))) {
					System.out.println("no");
					temp=false;
					break;
				}
			}
			
			if (temp)
			System.out.println("yes");
			
		}while(num!=0);
		
		
	}
	
}
