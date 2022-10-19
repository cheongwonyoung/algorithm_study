package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int min_val = Integer.MAX_VALUE;
        int min_idx = 0;
        String[] tem = in.readLine().split(" ");
        int n = Integer.parseInt(tem[0]);
        int m = Integer.parseInt(tem[1]);

        int[][] arr = new int[n+1][n+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++) {
                arr[i][j] = 1000000;
            }
        }

        for(int i=0; i<m; i++) {
            tem = in.readLine().split(" ");
            int x = Integer.parseInt(tem[0]);
            int y = Integer.parseInt(tem[1]);

            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        

    for(int k=1; k<n+1; k++) {
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(arr[i][k]+arr[k][j] < arr[i][j]) arr[i][j] = arr[i][k]+arr[k][j];
            }
            
        }
    }
    
    for(int i=1; i<n+1; i++) {
        int sum = 0;
        for(int j=1; j<n+1; j++) {
            if(i==j) continue;
            sum += arr[i][j];
        }
        if(min_val>sum) {
            min_val = sum;
            min_idx = i;
        }
    }

    System.out.println(min_idx);
}
}

