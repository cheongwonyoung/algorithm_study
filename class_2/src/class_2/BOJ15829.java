package class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15829 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(in.readLine());
		String[] str = in.readLine().split("");
		long sum = 0;
		long pow = 1;
		for (int i = 0; i < L; i++) {
			sum += (long) (str[i].charAt(0) - 96) * pow;
			pow = pow * 31 % 1234567891;
		}

		System.out.println(sum % 1234567891);
	}

}
