import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static int[] solution(int[] fees, String[] records) {
		// (차번호, 시간)
		HashMap<String, Integer> start_map = new HashMap<String, Integer>();
		HashMap<String, Integer> result_map = new HashMap<String, Integer>();
		int[] answer = {};
		int len = records.length;
		
		for(int i = 0; i<len; i++) {
			String[] tem = records[i].split(" ");
			// tem[0]은 시간
			// tem[1]은 차량번호
			// tem[2]는 입or출
			String[] temp = tem[0].split("");
			int hour = Integer.parseInt(temp[0]+temp[1])*60;
			int minute = Integer.parseInt(temp[3]+temp[4]);
			int time = hour + minute; // 해당 차의 입or출 시간
			
			// 들어오는 차량일때 (start_map에 차량번호와 입차 시간 기입)
			if(tem[2].equals("IN")) {
				start_map.put(tem[1], time);
				
			}
			// 나가는 차량일때 (들어온 시간을 가져와 사용 시간 계산)
			else { // "out"
				int total_time = time - start_map.remove(tem[1]);
				
				if(result_map.containsKey(tem[1])) {
					result_map.put(tem[1], result_map.get(tem[1])+total_time);
				}
				else {					
					result_map.put(tem[1], total_time);
				}
				
			}
		}

		// 위 과정을 끝냈는데 start_map에 값이 남아있다면 23:59 출차로 계산
		if(!start_map.isEmpty()) {
			for(String t : start_map.keySet()) {
				int val = 1439-start_map.get(t); 
				if(result_map.containsKey(t)) {
					result_map.put(t, result_map.get(t)+val);
				}
				else {					
					result_map.put(t, val);
				}
			}
		}

		
		List<String> list = new ArrayList<String>(result_map.keySet());
		Collections.sort(list);
			
		answer = new int[result_map.size()];
		int idx = 0;
		for(String e : list) {
			int tim = result_map.get(e); // 현재 차량의 주차 이용시간
			if(tim <= fees[0]) {
				answer[idx++] = fees[1];
			}
			else {
				// 기본 시간 이상 주차
				answer[idx++] = fees[1] + (int)Math.ceil((double)(tim-fees[0])/fees[2])* fees[3]; // 주차 요금 계산
				
			}			
		}
		
		return answer;
	}
}