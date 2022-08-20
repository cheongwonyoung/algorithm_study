package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ5464 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int[] rs = new int[n];
		int[] wk = new int[m];
		
		for (int i = 0; i < n; i++) {
			rs[i] = Integer.parseInt(in.readLine());
		}
		
		for (int i = 0; i < m; i++) {
			wk[i] = Integer.parseInt(in.readLine());
		}
		
	}
	
}
