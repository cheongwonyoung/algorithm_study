package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15961_회전초밥 {

	   public static void main(String[] args) throws Exception {
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      StringBuilder sb = new StringBuilder();
	      
	      String[] tem = in.readLine().split(" ");
	      int N = Integer.parseInt(tem[0]);
	      int d = Integer.parseInt(tem[1]);
	      int k = Integer.parseInt(tem[2]);
	      int c = Integer.parseInt(tem[3]);
	      int max = 0;
	      int temp = 0;
	      int idx = 0;
	      int len = N + k - 1;
	      int[] arr = new int[len];
	      int[] cnt = new int[d + 1];
	      
	      for (int i = 0; i < len; i++) {
	         if(i>=N) {
	        	 arr[i] = arr[idx++];
	        	 continue;
	         }
	         arr[i] = Integer.parseInt(in.readLine());
	      }

	      for (int i = 0; i < k; i++) {
	         if (cnt[arr[i]]++ == 0)
	            temp++;
	      }
 
	      if(cnt[c]==0) {
	    	  max = Math.max(max, temp + 1);
	      }
	      else {
	    	  max = Math.max(max, temp);
	      }
	      
	      for (int i = 1; i < len - k; i++) {
	         cnt[arr[i - 1]]--;
	         if (cnt[arr[i - 1]] == 0)
	            temp--;

	         if (cnt[arr[i + k - 1]]++ == 0)
	            temp++;
	         
	         if(cnt[c]==0) {
		    	  max = Math.max(max, temp + 1);
		      }
		      else {
		    	  max = Math.max(max, temp);
		      }
	      }

	      sb.append(max);

	      System.out.println(sb);
	   }
	}