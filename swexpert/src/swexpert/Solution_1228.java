
// 미완성

package swexpert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1228 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> inList = new ArrayList<Integer>();
		
		for(int tc=1; tc<=10; tc++) {
			int n = Integer.parseInt(in.readLine());
			String[] temp = in.readLine().split(" ");
			for(int i=0; i<n; i++) {
				list.add(Integer.parseInt(temp[i]));
			}
			
			int t = Integer.parseInt(in.readLine());
			temp = in.readLine().split(" ");
			int len = temp.length;
			
			int cnt =0;
			while(true) {
				if(temp[cnt].equals("I")) {
					int x = Integer.parseInt(temp[cnt+1]);
					int y = Integer.parseInt(temp[cnt+2]);
					for(int i=3; i<3+y; i++) {
						inList.add(Integer.parseInt(temp[cnt+i]));
					}
					for(int j=0; j<y; j++) {
						list.add(x+j, inList.get(j));
					}
					
					
					inList.clear();
					cnt += 2+y;
				}
				cnt+=1;
				if(cnt>=len) break;
				
			}
			cnt = 0;
			sb.append("#").append(tc).append(" ");
			for(Integer res : list) {
				sb.append(res).append(" ");
				cnt++;
				if(cnt==10) break;
			}
			sb.append("\n");
		}
		
			System.out.println(sb);
	}
	
}
