import java.io.*;
class Main {
	public static int N, answer;
	public static boolean[][] board;
	public static int[][] directions = {{-1, -1}, {1, -1}, {0, -1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new boolean[N][N];
		answer = 0;
		queen(0);
		System.out.print(answer);
	}
	public static void queen(int level) {
		if(level == N) {
			answer++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(check(i, level)) {
				board[i][level] = true;
				queen(level+1);
				board[i][level] = false;
			}
		}
	}
	public static boolean check(int y, int x) {
		for(int[] d : directions) {
			int dy = y + d[0];
			int dx = x + d[1];
			while(dy >= 0 && dy < N && dx >= 0) {
				if(board[dy][dx]) {
					return false;
				}
				dy += d[0];
				dx += d[1];
			}
		}
		return true;
	}
}