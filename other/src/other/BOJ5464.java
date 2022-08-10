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
		
//		Deque<Integer> rs = new ArrayDeque<>();
//		Queue<Integer> wa = new LinkedList<>();
//		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//		String[] temp = in.readLine().split(" ");
//		int n = Integer.parseInt(temp[0]);
//		int m = Integer.parseInt(temp[1]);
//		int sum = 0; // 출력값
//		int space = 0;
//		int waa=0;
//		int[] arr;
//		
////		int[] rs = new int[n]; // 단위 무게당 요금
//		int[] wk = new int[m]; // 차량의 무게
//		int[] seq = new int[m*2]; // 주차장 출입 순서
//		
//		for(int i=0; i<n; i++) {
//			rs.add(Integer.parseInt(in.readLine()));
//		}
//		for(int i=0; i<m; i++) {
//			wk[i] = Integer.parseInt(in.readLine());
//		}
//		for(int i=0; i<m*2; i++) {
//			seq[i] = Integer.parseInt(in.readLine());
//		}
//		
//		for(int j=0; j<m*2; j++) {
//			// 주차장 자리가 없고 들어오려는 차가 있는 경우
//			if(rs.size()==0 && seq[j]>0) {
//				// 대기 중인 차 저장
//				wa.add(seq[j]);
//			}
//			// 주차장에 자리가 있고, 차가 들어오려 할 때
//			else if(seq[j] > 0) {
//				// 주차공간 받고 map에 몇번째 차가 몇번 주차공간 사용하는지 저장
//				space = rs.poll();
//				map.put(seq[j],space);
//				sum += space*wk[seq[j]-1];
//				
//			}
//			else {
//				// 차가 나가는 경우 주차공간이 생겼음을 추가
//				rs.addFirst(map.get(Math.abs(seq[j])));
//				// 대기하는 차가 있고 주차공간이 있는경우
//				while(!(wa.isEmpty())&&!(rs.isEmpty())) {
//					// 주차공간과 대기하는 차번호 받기
//					space = rs.poll();
//					waa = wa.poll();
//					// map에 몇번째 차가 몇번 주차공간 사용하는지 저장
//					map.put(waa,space);
//					sum += space*wk[waa-1];
//				}
//			}
//		}
//		System.out.println(sum);
		
		
		String[] temp = in.readLine().split(" ");
		// n은 주차 공간 수
		int n = Integer.parseInt(temp[0]);
		// m은 차량 수 
		int m = Integer.parseInt(temp[1]);
		
		// rs는 주차 공간들의 단위 무게당 요금
		int[] rs = new int[n];
		// wk는 차량들의 무게를 나타내는 정수들
		int[] wk = new int[m];
		// seq는 주차하는 차량 순서
		int[] seq = new int[m*2];
		
		
		for(int i=0; i<n; i++) {
			rs[i] = Integer.parseInt(in.readLine());
		}
		for(int i=0; i<m; i++) {
			wk[i] = Integer.parseInt(in.readLine());
		}
		for(int i=0; i<m*2; i++) {
			seq[i] = Integer.parseInt(in.readLine());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
