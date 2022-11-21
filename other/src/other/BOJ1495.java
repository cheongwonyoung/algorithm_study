package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1495 {

    static int n,s,m;
    static int[] v;
    static int max_val = Integer.MIN_VALUE;
    static int temp = 0;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] tem = in.readLine().split(" ");

        n = Integer.parseInt(tem[0]); // 곡 수
        s = Integer.parseInt(tem[1]); // 시작 볼륨
        m = Integer.parseInt(tem[2]); // 최대 볼륨

        v = new int[n]; // 볼륨 리스트 
        check = new boolean[n];

        tem = in.readLine().split(" ");
        for(int i =0; i<n; i++) {
            v[i] = Integer.parseInt(tem[i]);
        }

        dfs(0);
        if(max_val < 0) max_val = -1;

        System.out.println(max_val);
    }

private static void dfs(int cnt) {
    if(cnt==n) {
        int temp=s;
        for(int i=0; i<n; i++) {
            if(check[i]) {
                if(temp + v[i] > m) {
                    return;
                }
                temp += v[i];
            }
            else {
                if(temp - v[i] <0) return;
                temp -= v[i];
            }
        }
        if(temp > max_val) max_val = temp;

        return;
    }
    
    check[cnt] =true;
    dfs(cnt+1);        
    check[cnt] =false;
    dfs(cnt+1);
    
}
}