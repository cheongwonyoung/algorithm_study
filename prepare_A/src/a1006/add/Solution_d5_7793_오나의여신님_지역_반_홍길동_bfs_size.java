package a1006.add;

import java.io.*;
import java.util.*;

public class Solution_d5_7793_오나의여신님_지역_반_홍길동_bfs_size{
	static int[] di={1,0,-1,0};
	static int[] dj={0,1,0,-1};
	static int ei=0, ej=0, temp =0;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d5_7793.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
        int T=Integer.parseInt(br.readLine());
        
        next:for(int tc=1; tc<=T; tc++){
        	StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            char[][] map=new char[N][M];
            Queue<int[]> q=new ArrayDeque<>();
            int[] S=null;
            for(int i=0; i<N; i++){
                map[i]=br.readLine().toCharArray();
                for(int j=0; j<M; j++){
                         if(map[i][j]=='S') S=new int[]{i,j,1};//연수
                    else if(map[i][j]=='*') q.offer(new int[]{i,j,0});//악마
                }
            }
            q.offer(S);
            int time=0;
            while(!q.isEmpty()){
            	time++;
            	int size= q.size();
            	for(int s=0; s<size; s++) {
            		int[] tem = q.poll();
                   	
                	if(tem[2]==0) { // 악마
                		int i = tem[0];
                		int j = tem[1];
                		
                		for(int d = 0; d<4; d++) {
                			int nr = i + di[d];
                			int nc = j + dj[d];
                			
                			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                			
                			if(map[nr][nc]=='.') {
                				q.offer(new int[] {nr, nc, 0});
                				map[nr][nc] = '*';
                			}
                			
                		}
                		
                	}
                	else if(tem[2]==1) { // 수연
                		int i = tem[0];
                		int j = tem[1];
                		
                		map[i][j] = 'X';
                		for(int d = 0; d<4; d++) {
                			int nr = i + di[d];
                			int nc = j + dj[d];
                			
                			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                			
                			if(ei==nr && ej==nc) {
                				sb.append("#").append(tc).append(" ").append(time).append("\n");
                    			continue next;
                    		}
                			
                			if(map[nr][nc]=='.') {
                				q.offer(new int[] {nr, nc, 1});
                			}
                			
                		}
                		
                	}
            	}
            }                 
            sb.append("#").append(tc).append(" GAME OVER").append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
