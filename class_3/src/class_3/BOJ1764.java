package class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class BOJ1764 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<String>();
		HashSet<String> set = new HashSet<>();

		String[] temp = in.readLine().split(" ");
		int n = Integer.parseInt(temp[0]); // 듣도 못한 사람의 수
		int m = Integer.parseInt(temp[1]); // 보도 못한 사람의 수 
	
//		듣도 못한 사람의 수를 Hashset으로 받음
//		Hashset.contains() // O(1)
//		List.contains() // O(n)
		for(int i=0; i<n; i++) {
			set.add(in.readLine());
		}

//		보도 못한 사람을 입력 받고 듣도 못한 사람에 있나 확인 후 있으면 리스트에 추가
		for(int i=0; i<m; i++) {
			String tem = in.readLine();
			if(set.contains(tem)) {
				result.add(tem);				
			}
		}
		
		// 사전순으로 정렬
		Collections.sort(result);
		
		int len = result.size();
		sb.append(len).append("\n");
		for(int i=0; i<len; i++) {
			sb.append(result.get(i)).append("\n");
			}
		System.out.println(sb);
		}
	
	
	
}
