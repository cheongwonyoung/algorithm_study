package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1210 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	
		int[][] arr = new int[100][100];
		int[] two_place = new int[2];
		int x=0;
		int y=0;
		int dl=0;
		int dr=-1;
		
		for(int t = 0; t<10; t++) {
			int T = Integer.parseInt(in.readLine());
			for (int i = 0; i < 100; i++) {
				String[] temp = in.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(temp[j]);
					if(arr[i][j] == 2) {
						y = i; 
						x = j;
					}
				}
			}
			
			while(true) {
				if(y == 0) {
					sb.append("#").append(T).append(" ").append(x).append("\n");
					break;
				}
				else if(dr==-1 && x-1 >= 0 && arr[y][x-1] == 1) {
					while(true) {
						if(x-1 < 0) break;
						x -= 1;
						if(arr[y][x]==0) {
							x += 1;
							break;
						}
					}
				}
				else if(dr==-1 && x+1 < 100 && arr[y][x+1] == 1) {
					while(true) {
						if(x+1 >= 100) break;
						x += 1;
						if(arr[y][x]==0) {
							x -= 1;
							break;
						}
					}
				}
				else {
					dl=0;
					dr=-1;
				}
				y+=dr;
				x+=dl;

			}	
			
		}
		
		System.out.println(sb);
		
	}

}
