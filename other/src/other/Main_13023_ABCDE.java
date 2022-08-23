package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_13023_ABCDE {
	
	static int n, m, cnt, result;

	static List<Integer>[] list;
	static boolean[] isCheck;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		
		String[] temp = in.readLine().split(" ");
		
		n = Integer.parseInt(temp[0]); // 사람 수	
		m = Integer.parseInt(temp[1]); // 친구관계 수
		
		list = new ArrayList[n];

		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
			
		
		isCheck = new boolean[n];
		
		for(int i=0; i<m; i++) {
			temp = in.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			list[a].add(b);
			list[b].add(a);
			
		}
	
		for(int i=0; i<n; i++) {
			cnt = 0;
			isCheck = new boolean[n];
			dfs(i);
			if(result==1) break;
		}

		System.out.println(result);
		
		
	}
	
	public static void dfs(int v) {
		if(cnt == 4) {
			result = 1;
			return;
		}
		isCheck[v] = true;
		for(int i =0; i<list[v].size(); i++) {
			int tem = list[v].get(i);
			if(!isCheck[tem]) {
				isCheck[tem] = true;
				cnt+=1;
				dfs(tem);
				isCheck[tem] = false;
				cnt-=1;
			}
		}
	}
	
}
