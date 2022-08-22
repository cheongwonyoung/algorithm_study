package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1759_암호만들기 {
	static boolean[] isCheck;
	static String[] nums;
	static String[] result;
	static int l, c, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		l = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);

		result = new String[l];
		nums = in.readLine().split(" "); // 소문자 문자열 (중복 x)

		Arrays.sort(nums);
		
		func(0, 0);
		
	
	}
	
	public static void func(int cnt, int start) {
		if(cnt==l) {
			int mo = 0;
			int za = 0;
			
			for(int i=0; i<l; i++) {
				if("aeiou".contains(result[i])) {
					mo += 1;
				}
				else {
					za += 1;
				}
			}
			if(mo>=1 && za>=2) {
				for(int i=0; i<l; i++) {
					System.out.print(result[i]);	
				}
				System.out.println();
				return;
			}
			else {
				return;
			}
			
		}
		
		for(int i=start; i<c;i++) {
			result[cnt] = nums[i];
			func(cnt+1, i+1);
				
		}
		
		
	}
	
}
