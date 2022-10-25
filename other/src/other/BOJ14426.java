package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tem = in.readLine().split(" ");

        int n = Integer.parseInt(tem[0]);
        int m = Integer.parseInt(tem[1]);

        String[] s = new String[n];
        for(int i=0; i<n; i++) {
            s[i] = in.readLine();
        }
        int cnt=0;
        String tail="";
        for(int i=0; i<m; i++) {
            tail = in.readLine();
            for(int k=0; k<n; k++) {

                if(tail.charAt(0) == s[k].charAt(0)) {
                    boolean flag=true;
                    for(int j=1; j<tail.length(); j++) {
                        if(!(tail.charAt(j)==s[k].charAt(j))) {
                            flag=false;
                        }
                    }
                    if(flag) {
                        cnt++;
                        break;
                    }
                }
            }

        }

        System.out.println(cnt);

}
}