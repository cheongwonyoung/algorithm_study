package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1873 {

		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int T = Integer.parseInt(in.readLine());
			for(int t = 0; t<T; t++) {
				String[] temp = in.readLine().split(" ");
				int H = Integer.parseInt(temp[0]);
				int W = Integer.parseInt(temp[1]);
				String shape ="";
				int r = 0;
				int c = 0;
	
				String[][] arr = new String[H][W];
				for(int i =0; i<H; i++) {
					temp = in.readLine().split("");
					for(int j=0; j<W; j++) {
						arr[i][j] = temp[j];
						if(temp[j].equals("^") || temp[j].equals("v") || temp[j].equals("<") || temp[j].equals(">")) {
							if(temp[j].equals("^")) {
								shape = "^";
								r = i;
								c = j;
								arr[i][j] = ".";
							}
							else if(temp[j].equals("v")) {
								shape = "v";
								r = i;
								c = j;
								arr[i][j] = ".";
							}
							else if(temp[j].equals("<")) {
								shape = "<";
								r = i;
								c = j;
								arr[i][j] = ".";
							}
							else if(temp[j].equals(">")) {
								shape = ">";
								r = i;
								c = j;
								arr[i][j] = ".";
							}
						}
					}
				}
				
				int n = Integer.parseInt(in.readLine());
				String[] com = in.readLine().split("");
				
				for(int i=0; i<n; i++) {
					int p=1;
					if(com[i].equals("U")) {
						shape = "^";
						if(r-1<0) continue;
						else if(arr[r-1][c].equals(".")) {
							r-=1;
						}
					}
					else if(com[i].equals("D")) {
						shape = "v";
						if(r+1>=H) continue;
						else if(arr[r+1][c].equals(".")) {
							r+=1;
						}
					}
					else if(com[i].equals("L")) {
						shape = "<";	
						if(c-1<0) continue;
						if(arr[r][c-1].equals(".")) {
							c-=1;
						}
					}
					else if(com[i].equals("R")) {
						shape = ">";
						if(c+1>=W) continue;
						if(arr[r][c+1].equals(".")) {
							c+=1;
						}
					}
					
					else if(com[i].equals("S")) {
						if(shape.equals("^")) {
							p = 1;
							while(true) {
								
								if(r-p<0) break;
								if(arr[r-p][c].equals("*")) {
									arr[r-p][c] = ".";
									break;
								}
								else if(arr[r-p][c].equals("#")||r-p-1<0) {
									break;
								}
								p++;
							}
										
						}
						else if(shape.equals("v")) {
							p = 1;
							while(true) {
								
								if(r+p>=H) break;
								if(arr[r+p][c].equals("*")) {
									arr[r+p][c] = ".";
									break;
								}
								else if(arr[r+p][c].equals("#")||r+p+1>=H) {
									break;
								}
								p++;
							}
						}
						else if(shape.equals("<")) {
							p = 1;
							while(true) {
								
								if(c-p<0) break;
								if(arr[r][c-p].equals("*")) {
									arr[r][c-p] = ".";
									break;
								}
								else if(arr[r][c-p].equals("#")||c-p-1<0) {
									break;
								}
								p++;
							}
						}
						else if(shape.equals(">")) {
							p = 1;
							while(true) {
								
								if(c+p>=W) break;
								if(arr[r][c+p].equals("*")) {
									arr[r][c+p] = ".";
									break;
								}
								else if(arr[r][c+p].equals("#")||c+p+1>=W) {
									break;
								}
								p++;
							}
						}
					}
				}
					arr[r][c] = shape;
				
//				System.out.print("#"+(t+1)+" ");
				sb.append("#").append(t+1).append(" ");
				
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
//						System.out.print(arr[i][j]);
					sb.append(arr[i][j]);
					}
					sb.append("\n");
//					System.out.println();
				}
				
			}
			System.out.println(sb);
		}
	
}
