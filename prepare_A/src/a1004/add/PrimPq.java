package a1004.add;

import java.io.*;
import java.util.*;

public class PrimPq {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/a1004/add/prim_input.txt"));
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] g=new int[N][N];
		boolean[] v=new boolean[N];
		int[] minEdge=new int[N]; //프림
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				g[i][j]=sc.nextInt();
			}
			minEdge[i]=Integer.MAX_VALUE;
		}
		int result=0, cnt=0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1], o2[1]));
		minEdge[0]=0;
		pq.offer(new int[] {0,0}); // 정점, 가중치
		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int minVertext=cur[0];
			int min=cur[1];
			if(v[minVertext]) continue;
			v[minVertext]=true;
			result+=min;
			if(cnt++ == N-1) break;
			for(int j=0; j<N; j++){
				if(!v[j] && g[minVertext][j]!=0 && minEdge[j]>g[minVertext][j]){
					                               minEdge[j]=g[minVertext][j];	
					                               pq.offer(new int[] {j,g[minVertext][j]});
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
