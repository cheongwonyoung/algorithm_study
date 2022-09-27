import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test1 {
	
	public static void main(String[] args) {

		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
//		System.out.println(Arrays.toString(today.split("[.]")));
		int[] result= solution(today, terms, privacies);
		System.out.println(Arrays.toString(result));
		
	}
	
	 public static int[] solution(String today, String[] terms, String[] privacies) {
		 	Map<String, Integer> map = new HashMap<String, Integer>();
		 	 
		 	int[] answer = {};
	        List<Integer> re = new ArrayList<Integer>();
	        
	        
	        // today
		 	String[] t = today.split("[.]");
		 	int year = Integer.parseInt(t[0]);
		 	int month = Integer.parseInt(t[1]);
		 	int day = Integer.parseInt(t[2]);
		 	
		 	// terms
		 	for(String temp : terms) {
		 		String[] tem = temp.split(" ");
		 		map.put(tem[0], Integer.parseInt(tem[1]));
		 	}
		 	
		 	// privacies
//		 	int cnt = 0; // 몇번째 정보인지
		 	int idx = -1;
		 	for(String temp : privacies) {
		 		idx++;
		 		String[] pr = temp.split(" ");
		 		t = pr[0].split("[.]");
		 		int p_year = Integer.parseInt(t[0]); 
		 		int p_month = Integer.parseInt(t[1]); 
		 		int p_day = Integer.parseInt(t[2]);
		 		p_month += map.get(pr[1]);
		 		if(p_month >= 12) {
		 			p_year += p_month/12;
		 			p_month = p_month%12;
		 		}
		 		// t[1] : A,B,C ..
		 		// t[0] 
//		 		System.out.println("idx = " + idx);
//		 		System.out.println("p_year = " + p_year + " p_month = " + p_month + " p_day = " + p_day);
//		 		System.out.println("year = " + year + " month = " + month + " day = " + day);
		 		if(year > p_year || (year==p_year&& month > p_month) || (year==p_year&& month == p_month && day >= p_day)) {
//		 			answer[cnt++] = idx+1;
		 			re.add(idx+1);
		 		}
		 		
		 		
		 	}
		 	
		 	int l = re.size();
		 	answer = new int[l];
		 	for(int i = 0; i<l; i++) {
		 		answer[i] = re.get(i);
		 	}
	        return answer;
	    }
}










