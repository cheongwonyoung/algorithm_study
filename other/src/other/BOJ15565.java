package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ15565 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		String[] tem = in.readLine().split(" ");
		int n = Integer.parseInt(tem[0]);
		int k = Integer.parseInt(tem[1]);

		int[] arr = new int[n];
		tem = in.readLine().split(" ");
		int min_val = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tem[i]);
			if (arr[i] == 1)
				list.add(i);
		}

		if (list.size() < k)
			min_val = -1;
		else {

			for (int i = 0; i < list.size(); i++) {
				if (list.size() - i < k)
					break;
				int temp = (list.get(i + k - 1) - '0') - (list.get(i) - '0') + 1;
				if (temp < min_val)
					min_val = temp;
			}
		}

		System.out.println(min_val);

	}
}