package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ2468{

static int n;
static int[][] arr;
static boolean[][] check;
static int[] dr = {-1, 1, 0, 0};
static int[] dc = {0, 0, -1, 1};
static int max_val = Integer.MIN_VALUE;
static int min_val = Integer.MAX_VALUE;
static int result=1;
public static void main(String[] args) throws Exception{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    n = Integer.parseInt(in.readLine());
    arr = new int[n][n];
    check = new boolean[n][n];
    for(int i=0; i<n; i++) {
        String[] tem = in.readLine().split(" ");
        for(int j=0; j<n; j++) {
            arr[i][j] = Integer.parseInt(tem[j]);
            if(arr[i][j] > max_val) max_val = arr[i][j];
            if(arr[i][j] < min_val) min_val = arr[i][j];
            
        }
    }

    for(int t=min_val; t<max_val; t++) {
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(arr[r][c]<=t) {
                    check[r][c] = true;
                }
            }
        }
        bfs(0,0);
        check=new boolean[n][n];
    }

    System.out.println(result);
    
}

static void bfs(int i, int j) {

    int cnt =0;
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    for(int r=0; r<n; r++) {
        for(int c=0; c<n; c++) {
            if(!check[r][c]) {
                check[r][c] = true;
                queue.add(new int[] {r,c});
                cnt++;
            }
            while(!queue.isEmpty()) {
                int[] temp = queue.poll();
                i = temp[0];
                j = temp[1];
                for(int d=0; d<4; d++) {
                    int nr=i+dr[d];
                    int nc=j+dc[d];
                    
                    if(nr<0 || nc<0 || nr>=n || nc>=n || check[nr][nc]) continue;
                    
                    check[nr][nc] = true;
                    
                    queue.add(new int[] {nr,nc});
                }
                
            }
            
        }
    }
    if(result<cnt) result = cnt;
    
}
}