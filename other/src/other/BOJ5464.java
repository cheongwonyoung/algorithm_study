package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ5464 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> rs = new ArrayDeque<>();
		Queue<Integer> wa = new LinkedList<>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		String[] temp = in.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int sum = 0; // 출력값
		int space = 0;
		int waa=0;
		int[] arr;
		
//		int[] rs = new int[n]; // 단위 무게당 요금
		int[] wk = new int[m]; // 차량의 무게
		int[] seq = new int[m*2]; // 주차장 출입 순서
		
		for(int i=0; i<n; i++) {
			rs.add(Integer.parseInt(in.readLine()));
		}
		for(int i=0; i<m; i++) {
			wk[i] = Integer.parseInt(in.readLine());
		}
		for(int i=0; i<m*2; i++) {
			seq[i] = Integer.parseInt(in.readLine());
		}
		
		for(int j=0; j<m*2; j++) {
			if(rs.size()==0 && seq[j]>0) {
				wa.add(seq[j]);
			}
			else if(seq[j] > 0) {
				space = rs.poll();
				map.put(seq[j],space);
				sum += space*wk[seq[j]-1];
				
			}
			else {
				rs.addFirst(map.get(Math.abs(seq[j])));
				while(!(wa.isEmpty())&&!(rs.isEmpty())) {
					space = rs.poll();
					waa = wa.poll();
					map.put(waa,space);
					sum += space*wk[waa-1];
				}
			}
		}
		System.out.println(sum);
	}
	
}
