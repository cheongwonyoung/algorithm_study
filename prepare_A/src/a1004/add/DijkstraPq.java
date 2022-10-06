package a1004.add;

import java.io.*;
import java.util.*;

public class DijkstraPq {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/a1004/add/dijkstra_input.txt"));
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] g=new int[N][N];
		boolean[] v=new boolean[N];
		int[] dist=new int[N]; //다익스트라
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				g[i][j]=sc.nextInt();
			}
			dist[i]=Integer.MAX_VALUE;
		}
//		int /*result=0,*/ cnt=0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[1], o2[1]));
		
		dist[0]=0;
		pq.offer(new int[] {0,0});
		v[0] = true;
		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int minVertext=cur[0];
			int min=cur[1];
			
		
			v[minVertext]=true;
			//result+=min;
			if(minVertext == -1) break;
			//if(cnt++ == N-1) break;
			for(int j=0; j<N; j++){
				if(!v[j] && g[minVertext][j]!=0 && dist[j]>min+g[minVertext][j]){
					                               dist[j]=min+g[minVertext][j];	
					                               pq.offer(new int[] {j,min+g[minVertext][j]});
				}
			}
		}
		System.out.println(dist[N-1]);
		sc.close();
	}
}
