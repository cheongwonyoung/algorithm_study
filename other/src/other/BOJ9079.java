package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9079 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			
			// 문자열 배열 입력
			String[][] arr = new String[3][3];
			for (int j = 0; j < 3; j++) {
				String[] temp = in.readLine().split(" ");
				for (int j2 = 0; j2 < 3; j2++) {
					arr[j][j2] = temp[j2];
				}
			}

			
			
		}

	}

}
