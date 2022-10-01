package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14888 {
	static int count;
	static int count_temp;
	static String[] val;
	static boolean[] check;
	static String[] cal;
	static int[] num;
	static int min_num = Integer.MAX_VALUE;
	static int max_num = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		num = new int[n];
		int[] buho = new int[4];
		
		
		String[] temp = in.readLine().split(" ");
		
		// 피연산자
		for(int i = 0; i<n; i++) {
			num[i] = Integer.parseInt(temp[i]);
		}
		// 연산자
		temp = in.readLine().split(" ");
		for(int i = 0; i<4; i++) {
			buho[i] = Integer.parseInt(temp[i]);
			count += Integer.parseInt(temp[i]);
		}
		cal = new String[count];
		check = new boolean[count];
		val = new String[count];
		int c = 0;
		
		for(int i = 0; i<buho[0]; i++) {
			cal[c++] = "+";
		}
		for(int i = 0; i<buho[1]; i++) {
			cal[c++] = "-";
		}
		for(int i = 0; i<buho[2]; i++) {
			cal[c++] = "*";
		}
		for(int i = 0; i<buho[3]; i++) {
			cal[c++] = "/";
		}
		
		perm(0);
//		System.out.println(count_temp);
		System.out.println(max_num);
		System.out.println(min_num);
	}
	
	static void perm(int cnt) {
		if(cnt == count) {
			
			int result = num[0];
			for(int i = 0; i<count; i++) {
				if(val[i].equals("+")) {
					result += num[i+1];
				}
				else if(val[i].equals("-")) {
					result -= num[i+1];
				}
				else if(val[i].equals("*")) {
					result *= num[i+1];
				}
				else {
					result /= num[i+1];
				}
			}
			
			if(result > max_num) {
				max_num = result;
			}
			if(result < min_num) {
				min_num = result;
			}
//			System.out.println(Arrays.toString(val));
//			count_temp++;
			return;
		}
		
		for(int i=0; i<count; i++) {
			if(check[i]) continue;
			
			check[i] = true;
			val[cnt] = cal[i];
			perm(cnt+1);
			check[i] = false;
			
		}
	}	
}
