//import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_두큐합같게만들기 {
	
	public static void main(String[] args) {
//		int[] queue1 = {3,2,7,2};
//		int[] queue2 = {4,6,5,1};
//		int[] queue1 = {1,2,1,2};
//		int[] queue2 = {1,10,1,2};
//		int[] queue1 = {1,1};
//		int[] queue2 = {1,5};
//		int result = solution(queue1, queue2);
//		System.out.println(result);
		
	}
	
	public static int solution(int[] queue1, int[] queue2) {
		int answer = -1;
        int len1 = queue1.length;
        int len2 = queue2.length;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> fQueue = new ArrayDeque<Integer>();
        Queue<Integer> sQueue = new ArrayDeque<Integer>();
        
        
        for(int i =0; i<len1; i++) {
        	sum1 += queue1[i];
        	fQueue.add(queue1[i]);
        }
        for(int i =0; i<len2; i++) {
        	sum2 += queue2[i];
        	sQueue.add(queue2[i]);
        }
        
        long mid = (sum1+sum2)/2;
        int temp = 0;
        int cnt = 0;
//        System.out.println(mid);
        while(true) {
//        	System.out.println("sum1 = " + sum1);
//        	System.out.println("sum2 = " + sum2);
        	
        	if(cnt > len1*4) {
        		break;
        	}
            else if(sum1 == mid && sum2 == mid) {
        		answer =cnt;
        		break;
        	}
        	else if (sum1>sum2) {
        		temp = fQueue.poll();
        		sum1 -= temp;
        		sum2 += temp;
        		sQueue.offer(temp);
        	}
        	else {
        		temp = sQueue.poll();
        		sum2 -= temp;
        		sum1 += temp;
        		fQueue.offer(temp);
        	}
        	cnt++;
        }
        return answer;
    }
}






