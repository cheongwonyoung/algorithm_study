package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 10; t++) {
			Deque<Integer> deque = new ArrayDeque<>();
			int tc = Integer.parseInt(in.readLine());
			String[] temp = in.readLine().split(" ");
			int val = 0;
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 8; i++) {
				deque.addLast(Integer.parseInt(temp[i]));
			}

			while (true) {
				val = deque.pollFirst();
				if (val - 1 <= 0) {
					deque.addLast(0);
					break;
				} else {
					deque.addLast(val - 1);
				}
				val = deque.pollFirst();
				if (val - 2 <= 0) {
					deque.addLast(0);
					break;
				} else {
					deque.addLast(val - 2);
				}
				val = deque.pollFirst();
				if (val - 3 <= 0) {
					deque.addLast(0);
					break;
				} else {
					deque.addLast(val - 3);
				}
				val = deque.pollFirst();
				if (val - 4 <= 0) {
					deque.addLast(0);
					break;
				} else {
					deque.addLast(val - 4);
				}
				val = deque.pollFirst();
				if (val - 5 <= 0) {
					deque.addLast(0);
					break;
				} else {
					deque.addLast(val - 5);
				}

			}
			for (int x : deque) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			

		}
		System.out.println(sb);
	}

}
