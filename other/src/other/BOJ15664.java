package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ15664 {

    static int[] arr;
    static int[] result;
    static int[] tempResult;
    static boolean[] check;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tem = in.readLine().split(" ");
        n = Integer.parseInt(tem[0]);
        m = Integer.parseInt(tem[1]);

        arr = new int[n];
        check = new boolean[n];
        result = new int[m];
        tempResult = new int[m];

        tem = in.readLine().split(" ");

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tem[i]);
        }
        Arrays.sort(arr);

        perm(0,0);

    }

private static void perm(int cnt, int start) {
    if(cnt==m) {
        for(int i=0; i<m; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        return;
    }
    
    int before=-1;
    for(int i=start; i<n; i++) {
        if(check[i] || before == arr[i]) continue;
        check[i] = true;
        result[cnt] = arr[i];
        before = arr[i];
        perm(cnt+1, i+1);
        check[i] = false;
    }

    
}
}