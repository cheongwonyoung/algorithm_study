package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1244 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치 개수
		int n = Integer.parseInt(in.readLine());
		// 스위치의 상태
		String[] switch_num = in.readLine().split(" ");
		// 학생 수 
		int cnt = Integer.parseInt(in.readLine());
		
		
		for(int i =0; i< cnt; i++) {
			// 학생 성별, 받은 번호
			String temp[] = in.readLine().split(" ");
			// 성별
			int s = Integer.parseInt(temp[0]);
			// 받은 번호 ( 1이상 스위치 개수 이하)
			int num = Integer.parseInt(temp[1]);
			
			// 남학생
			if(s==1) {
				int j = 1;
				while(num*j-1 >= 0 && num*j-1 < n) {

					if(switch_num[num*j-1].equals("1")) {
						switch_num[num*j-1] = "0";
						}
					else
						switch_num[num*j-1] = "1";
					j++;
				}
			}
			
			// 여학생
			else if(s==2) {
				
				int l = 0;
				if (num-l-1 >= 0 || num+l-1 <n) {
					while(switch_num[num-l-1].equals(switch_num[num+l-1])) {
						
						if(switch_num[num-l-1].equals("1")) {
							switch_num[num-l-1] = "0";
							switch_num[num+l-1] = "0";
						}
						else { 
							switch_num[num-l-1] = "1";
							switch_num[num+l-1] = "1";
						}
						l++;
						if (num-l-1 < 0 || num+l-1 >=n) break;
					}
				}
				
			}
		}
		
		for(int p =0; p<n; p++) {
			System.out.print(switch_num[p] + " ");

			if((p+1)%20 == 0) {
				System.out.println();
			}
		}
		

	}

}
