package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1244 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		String[] switch_num = in.readLine().split(" ");
		int cnt = Integer.parseInt(in.readLine());
		
		for(int i =0; i< cnt; i++) {
			String temp[] = in.readLine().split(" ");
			int s = Integer.parseInt(temp[0]);
			int num = Integer.parseInt(temp[1]);
			
			if(s==1) {
				int j = 1;
				while(num*j-1 >= 0 && num*j-1 < n) {
					if(switch_num[num*j-1]=="1")
						switch_num[num*j-1] = "0";
					else
						switch_num[num*j-1] = "1";
					j++;
				}
			}
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
			if(p!=0 && p%19==0) {
				System.out.println();
			}
		}
		
		

	}

}
