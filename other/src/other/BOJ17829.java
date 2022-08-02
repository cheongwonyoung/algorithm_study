package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17829 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 배열 크기, 배열
		int n = Integer.parseInt(in.readLine());
		int preArr[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] temp = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				preArr[i][j] = Integer.parseInt(temp[j]);
			}
			
		}
		
		// 줄어드는 nextArr (다음 결과배열)
		int[][] nextArr = new int[n][n];
		// 계산상 이전 배열
		int[][] tempArr = new int[n][n];
		tempArr = Arrays.copyOf(preArr, n);
		
		while(true) {
			n = n/2;
			int[] arr = new int[4];
			nextArr = new int[n][n];
			
			for(int i=0; i<n*2; i+=2) {
				for(int j=0; j<n*2; j+=2) {
					arr[0] = tempArr[i][j];
					arr[1] = tempArr[i][j+1];
					arr[2] = tempArr[i+1][j];
					arr[3] = tempArr[i+1][j+1];
					Arrays.sort(arr);
					
					nextArr[i/2][j/2] = arr[2];

				}
			}
			tempArr = Arrays.copyOf(nextArr, n);
			if(n==1) break;
			
		}
		
		System.out.println(nextArr[0][0]);
	}
	
}	
