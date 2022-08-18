package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1021 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();
		String[] temp = in.readLine().split(" ");
		// 큐의 크기
		int n = Integer.parseInt(temp[0]);
		// 뽑아내려고 하는 원소의 위치
		int m = Integer.parseInt(temp[1]);
		int cnt = 0;

		// 큐 생성
		for(int i=1; i<=n; i++) {
			deque.add(i);
		}
		
		temp = in.readLine().split(" ");
		for(String num : temp) {
			int val = Integer.parseInt(num);
			
			// 큐 복사
			Deque<Integer> tem = new ArrayDeque<>(deque);
			
			// 값이 deque안에서 몇번째에 있는지 탐색
			int len= 1;
			while (!tem.isEmpty()) {
				if(val == tem.pollFirst()) break;
				else len++;
				
			}
			
			// 첫번째 값으로 올때까지 반복
			while(true) {
				int size = deque.size();
				if(deque.getFirst() == val) {

					deque.pop();
					break;
				}
				// 왼쪽으로
				else if(len <= size/2+1) {
					deque.addLast(deque.pollFirst());
					
					cnt++;
				}
				// 오른쪽으로
				else {
					deque.addFirst(deque.pollLast());
					cnt++;
				}
			}
		}

		System.out.println(cnt);

	}
	
}
