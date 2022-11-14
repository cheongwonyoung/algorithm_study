//package other;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
//public class BOJ2012 {
//
//    static int n;
//    static int[] arr,result, think;
//    static boolean[] check;
//    static int min_val = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        n = Integer.parseInt(in.readLine());
//        arr = new int[n+1];
//        result = new int[n];
//        think = new int[n];
//        check = new boolean[n+1];
//
//        for(int i=0; i<n; i++) {
//            think[i] = Integer.parseInt(in.readLine());
//        }
//
//        perm(0);
//        System.out.println(min_val);
//    }
//
//    private static void perm(int i) {
//        if(i==n) {
//            int temp = 0;
//            for(int j=0; j<n; j++) {
////                System.out.print(result[j] + " ");
//                temp += Math.abs(think[j]-result[j]);
//            }
//            if(temp < min_val) min_val = temp;
////            System.out.println();
//            return;
//        }
//
//        for(int j=1; j<=n; j++) {
//            if(check[j]) continue;
//            result[i] = j;
//            check[j] = true;
//            perm(i+1);
//            check[j] = false;
//
//        }
//
//
//    }
//
//
//}
//
//
//
//
//

package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2012 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        long total = 0;
        for(int i=1; i<=n; i++) {
            total += Math.abs(arr[i-1] - i);
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(total);
    }

}