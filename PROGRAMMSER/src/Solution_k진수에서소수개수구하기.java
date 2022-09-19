import java.util.Arrays;

public class Solution_k진수에서소수개수구하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Integer.toString(437674,3).split("0")));
//		System.out.println(Arrays.toString(Integer.toString(110011,10).split("0")));
		
//		String[] tem = Integer.toString(110011,10).split("0");
		String[] tem = Integer.toString(437674,3).split("0");
		int len = tem.length;
		int total = 0;
		for(int i=0; i<len; i++) {
			if(tem[i].equals("")) continue;
			Long temp = Long.parseLong(tem[i]);
			if(temp==1) continue;
			if(temp==2) {
				total++;
				continue;
			}
			
			int cnt = 2;
			boolean check = true;
			while(cnt <= Math.sqrt(temp)) {
				if(temp%cnt==0) {
					check = false;
					break;
				}
				cnt++;
			}
			if(check) total++;
		}
		System.out.println(total);
		
	}
	
	public static int solution(int n, int k) {
		return k;
		
	}
}
