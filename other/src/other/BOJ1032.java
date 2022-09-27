package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		String[] array = new String[N];
		for(int i=0;i<N;i++) {
			array[i] = in.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		boolean isSame=true;
		for(int i=0;i<array[0].length();i++) {
			char c = array[0].charAt(i);
			
			isSame=true;
			for(int j=1;j<N;j++) {
				if(c!=array[j].charAt(i)) {
					isSame=false;
					break;
				}
			}
			
			if(isSame==true) {
				sb.append(c);
			} else
				sb.append('?');
		}
		System.out.println(sb.toString());
		
	}
	
}
