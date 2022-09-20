
public class Solution_파괴되지않은건물 {

	public static void main(String[] args) {
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		int result= solution(board, skill);
		System.out.println(result);
	}
	public static int solution(int[][] board, int[][] skill) {
		int answer = 0;
		int r = board.length;
		int c = board[0].length;
		
		int[][] sum = new int[r+1][c+1];
		
		for(int[] temp: skill) {
			if(temp[0]==1) {
				sum[temp[1]][temp[2]] -= temp[5];
				sum[temp[1]][temp[4]+1] += temp[5];
				sum[temp[3]+1][temp[2]] += temp[5];
				sum[temp[3]+1][temp[4]+1] -= temp[5];
			}
			else {
				sum[temp[1]][temp[2]] += temp[5];
				sum[temp[1]][temp[4]+1] -= temp[5];
				sum[temp[3]+1][temp[2]] -= temp[5];
				sum[temp[3]+1][temp[4]+1] += temp[5];
			}
		}
		
		for(int j=0; j<c+1; j++) {
			for(int i=0; i<r; i++) {
				sum[i+1][j] += sum[i][j];
			}
		}
		
		for(int i=0; i<r+1; i++) {
			for(int j=0; j<c; j++) {
				sum[i][j+1] += sum[i][j];
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(board[i][j] + sum[i][j] > 0 ) answer++;
			}
		}
		
		return answer;
		
		
	}
}
