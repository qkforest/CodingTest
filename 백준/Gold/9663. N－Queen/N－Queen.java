import java.io.*;
class Main {
	public static int N, answer;
	public static int[] board;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		answer = 0;
		queen(0);
		System.out.print(answer);
	}
	public static void queen(int level) {
		if(level == N) {
			answer++;
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(check(i, level)) {
				board[level] = i;
				queen(level+1);
				board[level] = 0;
			}
		}
	}
	public static boolean check(int y, int x) {
		for(int i = 0; i < x; i++) {
			if(board[i] == y) {
				return false;
			}
		}
		for(int i = x-1, j = y-1; i >= 0 && j >= 1; i--, j--) {
			if(board[i] == j) {
				return false;
			}
		}
		for(int i = x-1, j = y+1; i >= 0 && j <= N; i--, j++) {
			if(board[i] == j) {
				return false;
			}
		}
		return true;
	}
}