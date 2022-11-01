package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BOJ13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tem = in.readLine().split(" ");
		
		int n = Integer.parseInt(tem[0]);
		int w = Integer.parseInt(tem[1]);
		int l = Integer.parseInt(tem[2]);

		ArrayDeque<Integer> truck = new ArrayDeque<>();
		ArrayDeque<Integer> bridge = new ArrayDeque<>();
		
		int time=0;
		int weight=0;
		
		tem = in.readLine().split(" ");
		for(int i=0; i<n; i++) {
			truck.offer(Integer.parseInt(tem[i]));
		}
		
		for(int i=0; i<w; i++) {
			bridge.offer(0);
		}
		
		while(!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();
			
			if(!truck.isEmpty()) {
				if(truck.peek()+weight<=l) {
					weight += truck.peek();
					bridge.offer(truck.poll());
				}
				else {
					bridge.offer(0);
				}
			}
		}
		System.out.println(time);
		
		
	}
	
}
