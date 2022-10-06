package a1004.add;

import java.io.*;
import java.util.*;

public class Prim {
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
		minEdge[0]=0;
		for(int i=0; i<N; i++){
			int minVertext=-1;
			int min=Integer.MAX_VALUE;
			for(int j=0; j<N; j++){
				if(!v[j] && min>minEdge[j]){
					        minVertext=j;
					        min=minEdge[j];
				}
			}
			v[minVertext]=true;
			result+=min;
			if(cnt++ == N-1) break;
			for(int j=0; j<N; j++){
				if(!v[j] && g[minVertext][j]!=0 && minEdge[j]>g[minVertext][j]){
					                               minEdge[j]=g[minVertext][j];					
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
