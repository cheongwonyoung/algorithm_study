package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16935_배열돌리기3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");

		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int r = Integer.parseInt(temp[2]);
		
		// n*m행렬
		int[][] arr = new int[n][m];

		int[][] temp_arr = null;
		for(int i=0; i<n; i++) {
			temp = in.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		// r개의 연산
//		int[] cal = new int[r];
		temp = in.readLine().split(" ");
		
//		for(int i=0; i<r; i++) {
//			cal[i] = Integer.parseInt(temp[i]);
//		}
		
		for(int i=0; i<r; i++) {
			int num = Integer.parseInt(temp[i]);
			
			// 우 하 좌 상
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			
			switch(num) {
				case 1: // 상하반전
					int row = arr.length;
					int col = arr[0].length;
					
					temp_arr = new int[row][col];
					for(int rl=0; rl<row; rl++) {
						for(int cl=0; cl<col; cl++) {
							temp_arr[row-1-rl][cl] = arr[rl][cl];
						}
					}
					arr = temp_arr;
					break;
				case 2: // 좌우반전
					row = arr.length;
					col = arr[0].length;
					
					temp_arr = new int[row][col];
					for(int rl=0; rl<row; rl++) {
						for(int cl=0; cl<col; cl++) {
							temp_arr[rl][col-cl-1] = arr[rl][cl];
						}
					}
					arr = temp_arr;
					break;
				case 3: // 오른쪽으로 90도 회전
					row = arr.length;
					col = arr[0].length;
					
					temp_arr = new int[col][row];
					for(int rl=0; rl<row; rl++) {
						for(int cl=0; cl<col; cl++) {
							temp_arr[cl][row-1-rl] = arr[rl][cl];
							
						}
					}
					arr = temp_arr;
					break;
				case 4: // 왼쪽으로 90도 회전
					row = arr.length;
					col = arr[0].length;
					
					temp_arr = new int[col][row];
					for(int rl=0; rl<row; rl++) {
						for(int cl=0; cl<col; cl++) {
							temp_arr[col-1-cl][rl] = arr[rl][cl];
							
						}
					}
					arr = temp_arr;
					break;
				case 5: // 4등분 후 영역을 우른쪽으로 90도 회전
					row = arr.length;
					col = arr[0].length;
					
					temp_arr = new int[row][col];
					for(int a = 0; a < row; a++) {
						for(int b = 0; b < col; b++) {
							if(a < row/2 && b < col/2) {
								temp_arr[a][b+(col/2)] = arr[a][b];
							}
							
							else if(a < row/2 && b >= col/2) {								
								temp_arr[a+(row/2)][b] = arr[a][b];
							}
							
							else if(a >= row/2 && b >= col/2) {
								temp_arr[a][b-(col/2)] = arr[a][b];
							}
							
							else if(a >= row/2 && b < col/2) {
								temp_arr[a-(row/2)][b] = arr[a][b];
						}
					}
					
				}
					arr = temp_arr;
					break;
				case 6: // 4등분 후 영역을 우른쪽으로 90도 회전
					row = arr.length;
					col = arr[0].length;
					
					temp_arr = new int[row][col];
					for(int a = 0; a < n; a++) {
						for(int b = 0; b < col; b++) {
							if(a < row/2 && b < col/2) {
								temp_arr[a+(n/2)][b] = arr[a][b];
							}
							
							
							else if(a >= n/2 && b < m/2) {								
								temp_arr[a][b+(m/2)] = arr[a][b];
							}
							
							else if(a >= n/2 && b >= m/2) {
								temp_arr[a-(n/2)][b] = arr[a][b];
							}
							
							else if(a < n/2 && b >= m/2) {
								temp_arr[a][b-(m/2)] = arr[a][b];
						}
					}
					
				}
				arr = temp_arr;
					break;
		
			}
			
		}
		
		for(int i=0; i<temp_arr.length; i++) {
			for(int j=0; j<temp_arr[0].length; j++) {
				System.out.print(temp_arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
}
