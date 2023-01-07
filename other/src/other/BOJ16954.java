package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ16954 {

    // 상 상우 우 하우 하 좌하 좌 좌상 정지
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1, 0};
    static String[][] arr = new String[8][8];
    static boolean[][] check = new boolean[8][8];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<8; i++) {
            arr[i] = in.readLine().split("");
        }

        bfs(7,0,0);
        System.out.println(result);
    }

private static void bfs(int a, int b, int cnt) {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] {a,b,cnt});
    int fCnt = -1;
    
    while(!queue.isEmpty()) {
        int[] temp = queue.poll();
        int r = temp[0];
        int c = temp[1];
        cnt = temp[2];
        if(arr[r][c].equals("#")) continue;
        if(r==0 && c==7) {
            result = 1;
            return;
        }
        for(int d=0; d<9; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr<0 || nc<0 || nr>=8 || nc>=8 || check[nr][nc] || arr[nr][nc].equals("#")) continue;
            
            
            queue.offer(new int[] {nr,nc,cnt+1});
            check[nr][nc] = true;
        }
        
        if(fCnt!=cnt) {
            fCnt+=1;
            
            for(int i=7; i>=0; i--) {
                for(int j=0; j<8; j++) {
                    if(i==0) arr[i][j] = ".";
                    else arr[i][j] = arr[i-1][j];
                }
            }
        }
        
    }
    
}
}