package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11725 {

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(in.readLine());
    
    ArrayList<Integer>[] list = new ArrayList[n+1];
    int[] result = new int[n+1];
    boolean[] check = new boolean[n+1];
    
    for(int i=0; i<n+1; i++) {
        list[i] = new ArrayList<>();
    }
    
    for(int i=0; i<n-1; i++) {
        String[] tem = in.readLine().split(" ");
        int a = Integer.parseInt(tem[0]);
        int b = Integer.parseInt(tem[1]);
        list[a].add(b);
        list[b].add(a);
    
    }
    
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    check[1] = true;
    while(!queue.isEmpty()) {
        int p = queue.poll();
        for(int i=0; i<list[p].size(); i++) {
            if(!check[list[p].get(i)]) {
                check[list[p].get(i)]=true;
                result[list[p].get(i)] = p;
                queue.add(list[p].get(i));
            }
        }
        
    }
    for(int i=2; i<n+1; i++) {
        sb.append(result[i]).append("\n");
    }
    
    System.out.println(sb);
    
}


    
}