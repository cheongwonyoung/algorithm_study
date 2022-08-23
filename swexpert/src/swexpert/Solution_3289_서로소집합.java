package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3289_서로소집합 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t<=T; t++) {
			String[] temp = in.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]); // 연산의 개수
			int[] arr = new int[n+1]; // 집합
			for(int i=1; i<=n; i++) {
				arr[i] = i;
			}
			sb.append("#").append(t).append(" ");
			
			for(int i = 0; i<m; i++) {
				temp = in.readLine().split(" ");
				
				// 0:합집합 , 1:두 원소가 같은 집합인지 확인
				int cal = Integer.parseInt(temp[0]); 
				int a = Integer.parseInt(temp[1]);
				int b = Integer.parseInt(temp[2]);
				
				switch(cal) {
					// 합집합
					case 0:
						union(arr, a, b);
						break;
					// 두 원소가 같은 집합인지 확인
					case 1:
						if(find(arr, a)==find(arr, b)) {
							sb.append(1);
						}
						else {
							sb.append(0);
						}
						break;
					default:
						break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static int find(int[] arr, int n) {
		if(arr[n]==n) {
			return arr[n];
		}
		else {
			return find(arr, arr[n]);
		}
	}
	
	public static void union(int[] arr, int a, int b) {
		int x = find(arr, a);
		int y = find(arr, b);
		if(x < y) {
			arr[y] = x;
		}
		else {
			arr[x] = y;
		}
		
	}
	
	
}
