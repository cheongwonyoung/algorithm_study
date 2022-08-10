package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2615 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[20][20];
		
		
		for(int i=1; i<20; i++) {
			String[] temp = in.readLine().split(" ");
			for(int j=1; j<20; j++) {
				arr[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		// 하 우하 우 좌하
		boolean flag = true;
		boolean flag2 = true;
		
		int[] dr = {1, 1, 0, 1};
		int[] dc = {0, 1, 1, -1};
		
		for(int i=1; i<20; i++) {
			if(!flag) break;
			for(int j=1; j<20; j++) {
				if(!flag) break;
				if(arr[i][j]==1 || arr[i][j]==2) {
					for(int k=0; k<4; k++) {
						if(!flag) break;
						int r = dr[k]+i;
						int c = dc[k]+j;
						if(r<=0 || r>=20 || c<=0 || c>=20) break;
						if(arr[r][c] == arr[i][j]) {
							int cnt = 1;
							while(arr[r][c] == arr[i][j]) {

								if(!flag) break;
								cnt++;
								r = dr[k]+r;
								c = dc[k]+c;

								if(r<=0 || r>=20 || c<=0 || c>=20) break;

								if(r+dr[k]<=0 || r+dr[k]>=20 || c+dc[k]<=0 || c+dc[k]>=20) break;
								if(i-dr[k]<=0 || i-dr[k]>=20 || j-dc[k]<=0 || j-dc[k]>=20) break;
								if(cnt==5&& arr[i-dr[k]][j-dc[k]]!=arr[i][j] &&arr[r+dr[k]][c+dr[k]]!=arr[i][j]) {
									System.out.println(arr[i][j]);
									System.out.println((i) +" " + (j));
									flag2= false;
									flag = false;
								}
							}
						}
						
					}
				}
				
			}
		}
		if(flag2)
			System.out.println(0);
	}
	
}
