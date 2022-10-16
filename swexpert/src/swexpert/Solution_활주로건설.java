package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_활주로건설 {
	
	static int N,X,map[][],map2[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc=1; tc<=T; tc++) {
			String[] tem = in.readLine().split(" ");
			N = Integer.parseInt(tem[0]);
			X = Integer.parseInt(tem[1]);
			map = new int[N][N];
			map2 = new int[N][N];
			
			for(int i=0; i<N; i++) {
				tem = in.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map2[j][i] = map[i][j] = Integer.parseInt(tem[j]);
				}
			}
			System.out.println("#" + tc + " " + process());
		}
		
	}

	private static int process() {
		int count = 0;
		for(int i =0; i<N; i++) {
			if(makeRoad(map[i]))count++; // 수평 활주로 건설 체크
			if(makeRoad(map2[i]))count++; // 수직 활주로 건설 체크
		}
		return count;
		
	}
	
	// 해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false 리턴
	private static boolean makeRoad(int[] road) {
		 
		int beforeHeight = road[0], size = 0;
		int j = 0;
		
		while(j<N) {
			if(beforeHeight == road[j]) { // 동일높이
				size++;
				j++;
			}else if(beforeHeight+1 == road[j]) { //이전높이보다1높음 : 오르막 경사 설치 체크
				if(size<X) return false; // X길이 미만이면 활주로 건설 불가
				
				beforeHeight++;
				size = 1;
				j++;
				
			}else if(beforeHeight-1 == road[j]) { // 이전 높이보다 1 작음
				int count = 0;
				for(int k = j; k < N; k++) {
					if(road[k] != beforeHeight-1) return false;
					
					if(++count == X) break;
				}
				
				if(count < X) return false;
				
				beforeHeight--;
				j += X;
				size = 0;
				
			}else { // 높이가 2이상 차이
				return false;
			}
			
		}
		
		return true;
	}
	
}









