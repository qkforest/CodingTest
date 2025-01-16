import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[101][101];
		while(N > 0) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]) - 1;
			int b = Integer.parseInt(s[1]) - 1;
			board[b][a] += 1;
			board[b][a+10] -=1;
			board[b+10][a] -=1;
			board[b+10][a+10] += 1;
			N--;
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 1; j < 100; j++) {
				board[i][j] += board[i][j-1];
			}
		}
		for(int j = 0; j < 100; j++) {
			for(int i = 1; i < 100; i++) {
				board[i][j] += board[i-1][j];
			}
		}
		int answer = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(board[i][j] > 0) {
					answer++;
				}
			}
		}
		System.out.print(answer);
	}
}