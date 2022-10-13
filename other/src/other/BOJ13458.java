package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ13458 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		String[] tem = in.readLine().split(" ");
		
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tem[i]);
		}
		
		tem = in.readLine().split(" ");
		int b = Integer.parseInt(tem[0]);
		int c = Integer.parseInt(tem[1]);
		
		
		long answer=0;
	
		
		 for (int i = 0; i < n; i++) {
	            int students = arr[i];
	            students -= b; //총감독관은 무조건 한 명이므로
	            answer++; //감독관 수 1만 올려줌.

	            if (students > 0) { //총감독관이 감시하는 학생 수 제외한 나머지
	                if (students % c == 0) {
	                    answer += students / c;
	                }
	                else {  //부감독관이 감시하는 학생 수로 나누고 나머지가 남았으면 부감독관 1명 추가
	                    answer += students / c + 1;
	                }
	            }
	        }
	        System.out.println(answer);
	}
	
}
