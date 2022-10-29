package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11501 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(in.readLine());
            int[] arr = new int[n];
            int max_val = Integer.MIN_VALUE;

            long sum = 0;
            String[] tem = in.readLine().split(" ");
            for(int i =0; i<n; i++) {
                arr[i] = Integer.parseInt(tem[i]);
            }

            for(int i=n-1; i>=0; i--) {
                if(arr[i] > max_val) {
                    max_val = arr[i];
                }
                else {
                    sum += (max_val-arr[i]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }

}