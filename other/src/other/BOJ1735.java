package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1735 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 분수 1
		String[] temp1 = in.readLine().split(" ");
		int n1 = Integer.parseInt(temp1[0]);
		int m1 = Integer.parseInt(temp1[1]);

		// 분수 2
		String[] temp2 = in.readLine().split(" ");
		int n2 = Integer.parseInt(temp2[0]);
		int m2 = Integer.parseInt(temp2[1]);
		
		// 분모
		int temp_m1 = m1;
		int temp_m2 = m2;
		// 분자
		int temp_n1 = n1;
		int temp_n2 = n2;

		// 분모의 최소공배수 찾기
		while(true) {
			if(m1==m2) break;
			
			else if(m1 < m2) {
				m1 += temp_m1;
				n1 += temp_n1;
			}
			else {
				m2 += temp_m2;
				n2 += temp_n2;
			}
		}

		// 더해진 분수
		int mom = m1; // 분모
		int son = n1+n2; // 분자
		int gong = son; // 찾을 최소공배수
		
		while(true) {
			if(mom % gong == 0 && son%gong==0) {
				mom /= gong;
				son /= gong;
				break;
			}
			else {
				gong--;
			}
		}
		System.out.println(son +" " + mom);
	}

}
