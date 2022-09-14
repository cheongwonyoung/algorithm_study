import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_수식최대화 {
	static boolean[] check;
	static int[] val;
	static int cnt;
	
	static String[] buho = {"+","-","*"};
	
	static List<String> list_op;
	static List<Long> list_va;
	static List<Long> list_result;
	public static void main(String[] args) {
	
		String sik = "100-200*300-500+20";
		long result = solution(sik);
		System.out.println(result);

		
	}
	public static long solution(String expression) {
        long answer = 0;
        list_op = new ArrayList<String>();
        list_va = new ArrayList<Long>();
        list_result = new ArrayList<Long>();
       
        String[] tem = expression.split("");
        int len = tem.length;
        String temp = "";
        for(int i =0; i<len; i++) {
        	if(tem[i].equals("+") || tem[i].equals("-") ||tem[i].equals("*")) {
        		list_op.add(tem[i]);
        		list_va.add((long)Integer.parseInt((temp)));
        		temp="";
        	}
        	else {
        		temp += tem[i];
        	}
        	if(i==len-1) {
        		list_va.add((long)Integer.parseInt(temp));
        		temp="";
        	}
        }
        

        cnt = 3;
		val = new int[cnt+1];
		check = new boolean[cnt+1];

		perm(0);
		answer = (long)Collections.max(list_result);
        return answer;
    }
	
	public static void perm(int n) {
		if(n==cnt) {
			// list_ope
			// list_va
			List<Long> list_val = new ArrayList<>(list_va);
			List<String> list_ope = new ArrayList<>(list_op);
			for(int i =0; i<n; i++) {
				
//				System.out.print((val[i]-1) + " ");
				int idx = val[i]-1;
				String bu = buho[idx]; //현재 우선순위의 부호
//				System.out.print(list_val);
//				System.out.println(bu);
				while(list_ope.contains(bu)) {
					int l = list_ope.indexOf(bu);
					list_ope.remove(l);
					
					if(bu.equals("+")) {
						list_val.add(l, (list_val.get(l) + list_val.get(l+1)));
						list_val.remove(l+1);
						list_val.remove(l+1);
					}
					else if(bu.equals("-")) {
						list_val.add(l, (list_val.get(l) - list_val.get(l+1)));
						list_val.remove(l+1);
						list_val.remove(l+1);
					}
					else if(bu.equals("*")) {
						list_val.add(l, (list_val.get(l) * list_val.get(l+1)));
						list_val.remove(l+1);
						list_val.remove(l+1);
					}
					
				}
				
			}
//			System.out.println(list_val);
			list_result.add(Math.abs(list_val.get(0)));
			return;
		}
		for(int j =1; j<=cnt; j++) {
			if(check[j]) continue;
			check[j] = true;
			val[n] = j;
			perm(n+1);
			check[j] = false;
		}
		
		
		
	}
}

