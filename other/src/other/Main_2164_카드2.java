package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_카드2{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());	
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}

		while(!(queue.size() <= 1)) {

			queue.remove();
			if(queue.size()==1) break;
			queue.add(queue.poll());
			
		}
		System.out.println(queue.poll());
	
	}
	
	
}
