package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 

// 부분집합으로 몇번째 로우에 약품을 투입할지 정함.
// 어떤 약품을 투입할지 정해야 함.
public class Solution_보호필름 {
    static int d,w,k,cnt2;
    static int[][] arr;
    static int[][] tempArr;
    static boolean[] row;
    static boolean[] row2;
    static int min_val;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for(int tc=1; tc<=T; tc++) {
            String[] tem = in.readLine().split(" ");
            d = Integer.parseInt(tem[0]);
            w = Integer.parseInt(tem[1]);
            k = Integer.parseInt(tem[2]);

            arr = new int[d][w];
            row = new boolean[d];

            min_val = Integer.MAX_VALUE;

            for(int i=0; i<d; i++) {
                tem = in.readLine().split(" ");
                for(int j=0; j<w; j++) {
                    arr[i][j] = Integer.parseInt(tem[j]);
                }
            }

            tempArr = new int[d][w];
            for(int i=0; i<d; i++) {
                for(int j=0; j<w; j++) {
                    tempArr[i][j] = arr[i][j];
                }
            }

            check();
            if(min_val != 0)
                subset(0);
            sb.append("#").append(tc).append(" ").append(min_val).append("\n");
//            System.out.println(min_val);
        }
        System.out.println(sb);
    }

private static void subset(int cnt) {
    if(cnt==d) {
        // 몇번째 row에 넣을지 고른 상태
        cnt2=0;
        for(int i=0; i<d; i++) {
            if(row[i]) cnt2++;
        }
        
        //cnt2는 true의 갯수
        row2 = new boolean[cnt2];
        
        subset2(0);
        
        return;
    }
    
    row[cnt] = true;
    subset(cnt+1);
    row[cnt] = false;
    subset(cnt+1);
    
}
private static void subset2(int cnt) {
    if(cnt2==cnt) {
        // a,b중 어떤건지 선택해줘야 함

        tempArr = new int[d][w];
        for(int i=0; i<d; i++) {
            for(int j=0; j<w; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        int temp=0;
        for(int i=0; i<d; i++) {
            if(row[i]) {
                for(int l=0; l<w; l++) {
                    if(row2[temp]) {
                        tempArr[i][l] = 0;
                    }
                    else {
                        tempArr[i][l] = 1;
                    }
                }
                
                temp+=1;
            }
        }
        
        check();
        return;
        
    }
    
    row2[cnt] = true;
    subset2(cnt+1);
    row2[cnt] = false;
    subset2(cnt+1);
    
}

private static void check() {
    boolean result = true;
    for(int col=0; col<w; col++) {
        int cn=1;
        int start = tempArr[0][col];
        boolean flag = false;
        for(int row=1; row<d; row++) {
            if(start==tempArr[row][col]) {
                cn++;
            }
            else { 
                start = tempArr[row][col];
                cn = 1;
            }
            if(cn>=k) {
                flag=true;
                break;
            }
        }
        
        if(!flag) {
            result = false;
            break;
        }
    }

    if(result && (min_val > cnt2)) {
        min_val = cnt2;
    }
}
}