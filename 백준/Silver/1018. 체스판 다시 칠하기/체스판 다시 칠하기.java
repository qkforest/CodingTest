import java.io.*;
class Main {
	public static int N, M;
	public static char[][] board;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		board = new char[N][M];
		String[] s = {"WB", "BW"};
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		char[][] map1 = new char[8][8];
		char[][] map2 = new char[8][8];
		for(int i = 0; i < 8; i++) {
			map1[i] = s[(1+i)%2].repeat(4).toCharArray();
			map2[i] = s[i%2].repeat(4).toCharArray();
		}
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				answer = Math.min(answer, find(map1, i, j));
				answer = Math.min(answer, find(map2, i, j));
			}
		}

		System.out.print(answer);
	}
	public static int find(char[][] m, int y, int x) {
		int count = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[y+i][x+j] != m[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
}