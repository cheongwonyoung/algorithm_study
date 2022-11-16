package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_4193_수영대회 {

    static int n,cnt,endR,endC;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(in.readLine());
        for(int tc=1; tc<=t; tc++) {
            n = Integer.parseInt(in.readLine());
            arr = new int[n][n];
            visit = new boolean[n][n];
            String[] tem;

            // 0: 지나갈 수 있, 1:장애물, 2:주기가 2초인 소용돌이
            for(int i=0; i<n; i++) {
                tem = in.readLine().split(" ");
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(tem[j]);
                }
            }

            //시작위치
            tem = in.readLine().split(" ");
            int a = Integer.parseInt(tem[0]);
            int b = Integer.parseInt(tem[1]);
//            int[] start = new int[] {a,b};

            //도착위치
            tem = in.readLine().split(" ");
            endR = Integer.parseInt(tem[0]);
            endC = Integer.parseInt(tem[1]);
//            int[] end = new int[] {c,d};
            if(endR==a && endC==b) cnt=0;
            else bfs(a,b);

//            System.out.println(cnt);
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);

    }

private static void bfs(int i, int j) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    visit[i][j] = true;
    cnt=0;
    queue.offer(new int[] {i,j,cnt});
    
    while(!queue.isEmpty()) {
        int[] temp = queue.poll();
        i = temp[0];
        j = temp[1];
        cnt = temp[2];
        if(i==endR && j==endC) return;
        
        for(int d=0; d<4; d++) {
            int nr = i+dr[d];
            int nc = j+dc[d];
            
            if(nr<0 || nc<0 || nr>=n || nc>=n || visit[nr][nc] || arr[nr][nc]==1) continue; // 범위를 넘어가거나 장애물이 있는 경우
            
            // 소용돌이가 있는 경우
            if(arr[nr][nc]==2 && (cnt+1)%3!=0) {
                queue.offer(new int[]{i,j, cnt+1});    
            }
            // 일반 경로인 경우
            else {                        
                queue.offer(new int[]{nr,nc, cnt+1});
                visit[nr][nc] = true;
            }
        }
        
    }
    
    cnt = -1;
}
}