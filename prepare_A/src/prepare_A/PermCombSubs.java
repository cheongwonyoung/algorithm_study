package prepare_A;

import java.io.*;
import java.util.*;

// 4P3 = 24, nCr, 2^n
public class PermCombSubs {
	static int N=4, R=3, C=0;
	static int[] a= {1,2,3,4}, b=new int[R];
	static boolean[] v=new boolean[N];
	
	
	public static void main(String[] args) throws Exception {
//		perm(0); // 순열 4P3 = 4*3*2=24
//		System.out.println(C);
//		
//		sperm(0); // 중복순열 4ㅠ3=4*4*4=64
//		System.out.println(C);
		
//		comb(0, 0); // 조합 4C3=4!/3!=4
//		System.out.println(C);
		
//		scomb(0, 0); // 중복조합 4C3=4!/3!=4
//		System.out.println(C);
		
		subs(0); // 부분집합 s^4=16 
		System.out.println(C);
	}

	// 순열
	static void perm(int depth) {
		if(depth==R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for(int i = 0; i<N; i++) {
			if(v[i]==true) continue;
			v[i] = true;
			b[depth] = a[i];
			perm(depth+1);
			v[i] = false;
		}
		
		
	}
	
	// 중복순열
	static void sperm(int depth) {
		if(depth==R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for(int i = 0; i<N; i++) {
//			if(v[i]==true) continue;
//			v[i] = true;
			b[depth] = a[i];
			sperm(depth+1);
//			v[i] = false;
		}
		
		
	}
	
	// 조합
	static void comb(int depth, int start) {
		if(depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for(int i=start; i<N; i++) {
			b[depth] = a[i];
			comb(depth+1, i+1);
		}
	}
	
	// 중복조합
	static void scomb(int depth, int start) {
		if(depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}
		for(int i=start; i<N; i++) {
			b[depth] = a[i];
			scomb(depth+1, i);
		}
	}
	
	// 부분집합
	static void subs(int depth) {
		if(depth==N) {
			for(int i =0; i<N; i++) {				
				System.out.print(v[i]? a[i]:"X");
				
			}
			System.out.println();
			C++;
			return;
		}
		v[depth]=true;
		subs(depth+1);
		v[depth]=false;
		subs(depth+1);
	}
	
}
