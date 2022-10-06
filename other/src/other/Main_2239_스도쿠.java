package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_2239_스도쿠 {

	static int[][] arr = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i =0; i<9; i++) {
			String[] temp = in.readLine().split("");
			for(int j =0; j<9; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}

		meth(0,0);
		
		for(int i = 0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void meth(int i, int j) {

			while(true) {
				
				if(j==8) {
					i+=1;
					j=0; 
				}
				else {
					j = j+1;
				}
				System.out.println(i + " " + j);
				if(arr[i][j]!=0 && !(i==8 && j==8)) continue;
				for(int val=1; val<=9; val++) {
					if(checkRow(i,j, val) && checkCol(i,j,val) && checkRec(i,j,val)) {
						arr[i][j] = val;
						break;
					}
					else {
						return;
					}
				}

				if(i==8 && j==8) return;
		}
		
	}

	
	private static boolean checkRow(int i, int j, int val) {
		
		for(int c = 0; c<9; c++) {
			if(c==j) continue;
			else if(arr[i][c] == val) return false;
		} 
		return true;
	}
	private static boolean checkCol(int i, int j, int val) {
		for(int r = 0; r<9; r++) {
			if(r==i) continue;
			else if(arr[r][j] == val) return false;
		} 
		return true;
	}
	private static boolean checkRec(int i, int j, int val) {
		if(i>=0 && i<3 && j>=0 && j<3) {
			for(int r = 0; r<3; r++) {
				for(int c = 0; c<3; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=0 && i<3 && j>=3 && j<6) {
			for(int r = 0; r<3; r++) {
				for(int c = 3; c<6; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=0 && i<3 && j>=6 && j<9) {
			for(int r = 0; r<3; r++) {
				for(int c = 6; c<9; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=3 && i<6 && j>=0 && j<3) {
			for(int r = 3; r<6; r++) {
				for(int c = 0; c<3; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=3 && i<6 && j>=3 && j<6) {
			for(int r = 3; r<6; r++) {
				for(int c = 3; c<6; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=3 && i<6 && j>=6 && j<9) {
			for(int r = 3; r<6; r++) {
				for(int c = 6; c<9; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=6 && i<9 && j>=0 && j<3) {
			for(int r = 6; r<9; r++) {
				for(int c = 0; c<3; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=6 && i<9 && j>=3 && j<6) {
			for(int r = 6; r<9; r++) {
				for(int c = 3; c<6; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		else if(i>=6 && i<9 && j>=6 && j<9) {
			for(int r = 6; r<9; r++) {
				for(int c = 6; c<9; c++) {
					if(arr[r][c]==val) return false;
				}
			}
		}
		return true;
	}
	
}
