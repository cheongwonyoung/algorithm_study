package class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		int tc = Integer.parseInt(in.readLine());
		int max_val = Integer.MIN_VALUE;
		// 입력받은 값중 최대값 찾기 (배열 만들기 위해)
		for (int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(in.readLine());
			list.add(n);
			if(max_val < n) {
				max_val = n;
			}
		}
		// 1번째 인덱스가 1번째 항 
		int[] arr = new int[max_val + 1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		// 4번째 항부터 끝까지 돌며 이전 세 항의 가지수 합을 이번 항에 넣어줌
		for(int j=4; j<=max_val; j++) {
			arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
		}
		// 입력 받은 리스트에서 하나씩 가져와 알고자 하는 항에서의 가지수를 가져옴.
		for(int k=0; k<list.size(); k++) {
			sb.append(arr[list.get(k)]).append("\n");
		}
		
		System.out.println(sb);

	}

}
