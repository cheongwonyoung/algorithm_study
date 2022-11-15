package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15656 {

static int n,m;
static boolean[] check;
static int[] arr,result;
static StringBuilder sb;
public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    String[] tem = in.readLine().split(" ");
    
    n = Integer.parseInt(tem[0]);
    m = Integer.parseInt(tem[1]);
    
    check = new boolean[n];
    arr = new int[n];
    result = new int[m];
    
    tem = in.readLine().split(" ");
    for(int i=0; i<n; i++) {
        arr[i] = Integer.parseInt(tem[i]);
    }
    Arrays.sort(arr);
    comb(0);
    System.out.println(sb);
}

private static void comb(int cnt) {
    if(m==cnt) {
        for(int i=0; i<m; i++) {
            sb.append(result[i]).append(" ");
//                System.out.print(result[i] + " ");
            }
//            System.out.println();
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
//            if(check[i]) continue;
//            check[i] = true;
            result[cnt] = arr[i];
            comb(cnt+1);
//            check[i] = false;
        }

    }

}