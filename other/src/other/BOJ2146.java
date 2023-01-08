package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ2146 {

static int n;
static int[][] arr;
static boolean[][] check;
static boolean[][] check2;

static int[] dr = {-1,1,0,0};
static int[] dc = {0,0,-1,1};
static int num = 1;
static int min_val = Integer.MAX_VALUE;

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(in.readLine());
    
    arr = new int[n][n];
    check = new boolean[n][n];
    check2 = new boolean[n][n];
    
    for(int i=0; i<n; i++) {
        String[] tem = in.readLine().split(" ");
        for(int j=0; j<n; j++) {
            arr[i][j] = Integer.parseInt(tem[j]);
        }
    }
    
    // 라벨링
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(!check[i][j] && arr[i][j]!=0) {                    
                bfs1(i,j);
            }
        }
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(!check2[i][j] && (arr[i][j] > 1 ) ) {
                bfs2(i,j,0);
                check2 = new boolean[n][n];
            }
        }
    }
    
    System.out.println(min_val);
    
}

private static void bfs2(int a, int b, int len) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] {a,b,len});
    
    check2[a][b] = true;
    
    while(!queue.isEmpty()) {
        int[] temp = queue.poll();
        int r = temp[0];
        int c = temp[1];
        int cnt = temp[2];
        
        if(cnt > min_val) continue;
        
        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            
            if(nr<0||nc<0||nr>=n||nc>=n||check2[nr][nc]) continue;
            
            if(arr[nr][nc]>1 && arr[a][b]!=arr[nr][nc]) {
                if(min_val > cnt) min_val = cnt;
                continue;
            }
            
            if(arr[nr][nc]!=0) continue;
            
            queue.offer(new int[] {nr,nc, cnt+1});
            check2[nr][nc] = true;
            
        }
    }
    
}

private static void bfs1(int a, int b) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] {a,b});
    check[a][b] = true;
    num += 1;
    arr[a][b] = num;
    
    
    while(!queue.isEmpty()) {
        int[] temp = queue.poll();
        int r = temp[0];
        int c = temp[1];
        
        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            
            if(nr<0||nc<0||nr>=n||nc>=n||check[nr][nc]||arr[nr][nc]==0) continue;
            
            queue.offer(new int[] {nr,nc});
            check[nr][nc] = true;
            arr[nr][nc] = num;
            
            
        }
        
    }
    
}
}