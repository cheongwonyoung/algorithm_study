package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Solution_4013_특이한자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		// tc
		for(int t = 1; t<=T; t++) {
			// 자석을 회전 시키는 횟수
			sb.append("#").append(t).append(" ");
			int k = Integer.parseInt(in.readLine());
			int result = 0;
//			int[] arr1 = new int[8];
//			int[] arr2 = new int[8];
//			int[] arr3 = new int[8];
//			int[] arr4 = new int[8];
			Deque<Integer> arr1 = new ArrayDeque<>();
			Deque<Integer> arr2 = new ArrayDeque<>();
			Deque<Integer> arr3 = new ArrayDeque<>();
			Deque<Integer> arr4 = new ArrayDeque<>();
			
			String[] tem1 = in.readLine().split(" ");
			String[] tem2 = in.readLine().split(" ");
			String[] tem3 = in.readLine().split(" ");
			String[] tem4 = in.readLine().split(" ");
			
			for(int i = 0; i<8; i++) {
				// 4개 자석의 8개의 날의 자성정보 (0은 N, 1은 S)
				arr1.add(Integer.parseInt(tem1[i]));
				arr2.add(Integer.parseInt(tem2[i]));
				arr3.add(Integer.parseInt(tem3[i]));
				arr4.add(Integer.parseInt(tem4[i]));
			}
			for(int j = 0; j<k; j++) {
				Iterator<Integer> it1 = arr1.iterator();
				Iterator<Integer> it2 = arr2.iterator();
				Iterator<Integer> it3 = arr3.iterator();
				Iterator<Integer> it4 = arr4.iterator();
				
				int arr1_3 = 0;
				int arr2_3 = 0;
				int arr2_7 = 0;
				int arr3_3 = 0;
				int arr3_7 = 0;
				int arr4_7 = 0;
				
				String[] tem = in.readLine().split(" ");
				int cnt = Integer.parseInt(tem[0]); // 자석번호
				int dir = Integer.parseInt(tem[1]); // 왼(-1) , 오(1)
				
				
				// 겹치는 부분들의 값 찾아내기
				for(int q = 0; q<7; q++) {
					if(q==2) {
						arr1_3 = it1.next();
						arr2_3 = it2.next();
						arr3_3 = it3.next();
					}
					else if(q==6) {
						arr2_7 = it2.next();
						arr3_7 = it3.next();
						arr4_7 = it4.next();
					}
					if(q!=2 && q!=6) {		
						it2.next();
						it3.next();
					}
					it4.next();
				}
				
				switch(cnt) {
					// 1번자석
					case 1:
						// 같으면 1번자석만 돌리고 end
						if(arr1_3==arr2_7) {
							if(dir==1) { // 오
								arr1.addFirst(arr1.pollLast());
							}
							else { // 왼
								arr1.addLast(arr1.pollFirst());
							}
						}
						else { // 다르면 2번도 돌리기
							// 2번과 3번이 같으면 2번만 돌리기
							if(arr2_3==arr3_7) {
								if(dir==1) { // 오
									arr1.addFirst(arr1.pollLast());
									arr2.addLast(arr2.pollFirst());
								}
								else { // 왼
									arr1.addLast(arr1.pollFirst());
									arr2.addFirst(arr2.pollLast());
								}
							}
							// 2번과 3번이 다르면 2,3 둘 다 돌리기
							else {
								// 3번과 4번이 같으면 3번까지만 돌리기
								if(arr3_3==arr4_7) {
									if(dir==1) { // 오
										arr1.addFirst(arr1.pollLast());
										arr2.addLast(arr2.pollFirst());
										arr3.addFirst(arr3.pollLast());
									}
									else { // 왼
										arr1.addLast(arr1.pollFirst());
										arr2.addFirst(arr2.pollLast());
										arr3.addLast(arr3.pollFirst());
									}
								}
								else { // 3번과 4번이 다르면 
									if(dir==1) { // 오
										arr1.addFirst(arr1.pollLast());
										arr2.addLast(arr2.pollFirst());
										arr3.addFirst(arr3.pollLast());
										arr4.addLast(arr4.pollFirst());
									}
									else { // 왼
										arr1.addLast(arr1.pollFirst());
										arr2.addFirst(arr2.pollLast());
										arr3.addLast(arr3.pollFirst());
										arr4.addFirst(arr4.pollLast());
									}
								}
							}
						}
						break;
						
					// 2번자석
					case 2:
						// 같으면 2번자석만 돌리고 end
						if(arr1_3==arr2_7 && arr2_3==arr3_7) {
							if(dir==1) { // 오
								arr2.addFirst(arr2.pollLast());
							}
							else { // 왼
								arr2.addLast(arr2.pollFirst());
							}
						}
						else if(arr3_7==arr2_3){ // 다르면 1,2번 돌리기
							if(dir==1) { // 오
								arr2.addFirst(arr2.pollLast());
								arr1.addLast(arr1.pollFirst());
							}
							else { // 왼
								arr2.addLast(arr2.pollFirst());
								arr1.addFirst(arr1.pollLast());
							}
							}
						else if(arr1_3==arr2_7) { // 다르면 2, 3번 돌리기
							if(dir==1) { // 오
								arr2.addFirst(arr2.pollLast());
								arr3.addLast(arr3.pollFirst());
							}
							else { // 왼
								arr2.addLast(arr2.pollFirst());
								arr3.addFirst(arr3.pollLast());
							}	
						}
						else { // 다 돌리기
							if(arr3_3==arr4_7) {								
								if(dir==1) { // 오
									arr2.addFirst(arr2.pollLast());
									arr1.addLast(arr1.pollFirst());
									arr3.addLast(arr3.pollFirst());
								}
								else { // 왼
									arr2.addLast(arr2.pollFirst());
									arr1.addFirst(arr1.pollLast());
									arr3.addFirst(arr3.pollLast());
								}
							}
							else { // 4도 돌리기
								if(dir==1) { // 오
									arr2.addFirst(arr2.pollLast());
									arr1.addLast(arr1.pollFirst());
									arr3.addLast(arr3.pollFirst());
									arr4.addFirst(arr4.pollLast());
								}
								else { // 왼
									arr2.addLast(arr2.pollFirst());
									arr1.addFirst(arr1.pollLast());
									arr3.addFirst(arr3.pollLast());
									arr4.addLast(arr4.pollFirst());
								}
							}
						}
						break;
						
					// 3번자석
					case 3:
						// 같으면 2번자석만 돌리고 end
						if(arr3_7==arr2_3 && arr4_7==arr3_3) {
							if(dir==1) { // 오
								arr3.addFirst(arr3.pollLast());
							}
							else { // 왼
								arr3.addLast(arr3.pollFirst());
							}
						}
						else if(arr3_7==arr2_3){ // 3, 4 돌리기
							if(dir==1) { // 오
								arr3.addFirst(arr3.pollLast());
								arr4.addLast(arr4.pollFirst());
							}
							else { // 왼
								arr3.addLast(arr3.pollFirst());
								arr4.addFirst(arr4.pollLast());
							}
							}
						else if(arr4_7==arr3_3) { // 2, 3번 돌리기
							if(dir==1) { // 오
								arr3.addFirst(arr3.pollLast());
								arr2.addLast(arr2.pollFirst());
							}
							else { // 왼
								arr3.addLast(arr3.pollFirst());
								arr2.addFirst(arr2.pollLast());
							}	
						}
						else { // 다 돌리기
							if(arr1_3==arr2_7) {								
								if(dir==1) { // 오
									arr3.addFirst(arr3.pollLast());
									arr2.addLast(arr2.pollFirst());
									arr4.addLast(arr4.pollFirst());
								}
								else { // 왼
									arr3.addLast(arr3.pollFirst());
									arr2.addFirst(arr2.pollLast());
									arr4.addFirst(arr4.pollLast());
								}
							}
							else { // 1도 돌리기
								if(dir==1) { // 오
									arr3.addFirst(arr3.pollLast());
									arr2.addLast(arr2.pollFirst());
									arr4.addLast(arr4.pollFirst());
									arr1.addFirst(arr1.pollLast());
								}
								else { // 왼
									arr3.addLast(arr3.pollFirst());
									arr4.addFirst(arr4.pollLast());
									arr2.addFirst(arr2.pollLast());
									arr1.addLast(arr1.pollFirst());
								}
							}
						}
						break;
						
					// 4번자석
					case 4:
						// 같으면 4번자석만 돌리고 end
						if(arr4_7==arr3_3) {
							if(dir==1) { // 오
								arr4.addFirst(arr4.pollLast());
							}
							else { // 왼
								arr4.addLast(arr4.pollFirst());
							}
						}
						else { // 다르면 2번도 돌리기
							// 2번과 3번이 같으면 2번만 돌리기
							if(arr2_3==arr3_7) {
								if(dir==1) { // 오
									arr4.addFirst(arr4.pollLast());
									arr3.addLast(arr3.pollFirst());
								}
								else { // 왼
									arr4.addLast(arr4.pollFirst());
									arr3.addFirst(arr3.pollLast());
								}
							}
							// 2번과 3번이 다르면 2,3 둘 다 돌리기
							else {
								// 1번과 2번이 같으면 2번까지만 돌리기
								if(arr1_3==arr2_7) {
									if(dir==1) { // 오
										arr4.addFirst(arr4.pollLast());
										arr3.addLast(arr3.pollFirst());
										arr2.addFirst(arr2.pollLast());
									}
									else { // 왼
										arr4.addLast(arr4.pollFirst());
										arr3.addFirst(arr3.pollLast());
										arr2.addLast(arr2.pollFirst());
									}
								}
								else { // 1번과 2번이 다르면 
									if(dir==1) { // 오
										arr4.addFirst(arr4.pollLast());
										arr3.addLast(arr3.pollFirst());
										arr2.addFirst(arr2.pollLast());
										arr1.addLast(arr1.pollFirst());
									}
									else { // 왼
										arr4.addLast(arr4.pollFirst());
										arr3.addFirst(arr3.pollLast());
										arr2.addLast(arr2.pollFirst());
										arr1.addFirst(arr1.pollLast());
									}
								}
							}
						}
						break;
					
				}
				
				System.out.println();
				Iterator<Integer> it13 = arr1.iterator();
				Iterator<Integer> it23 = arr2.iterator();
				Iterator<Integer> it33 = arr3.iterator();
				Iterator<Integer> it43 = arr4.iterator();
				for(int h = 0; h<8; h++) {
					System.out.print(it13.next() + " ");
				}
				System.out.println();
				
			}
			
			result = arr1.getFirst() + arr2.getFirst()*2 + arr3.getFirst()*4 + arr4.getFirst()*8;
			sb.append(result).append("\n");
		}
		System.out.println(sb);

}}
