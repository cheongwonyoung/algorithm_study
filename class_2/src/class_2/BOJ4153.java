package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] temp = in.readLine().split(" ");
			int[] arr = {Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2])};
			Arrays.sort(arr);
			int n1 = arr[0];
			int n2 = arr[1];
			int n3 = arr[2];
			
			if(n1+n2+n3 == 0) break;

			if((int)Math.pow(n3, 2) == (int)Math.pow(n1, 2)+(int)Math.pow(n2, 2)) System.out.println("right");
			else System.out.println("wrong");
			
		}
	}
}
