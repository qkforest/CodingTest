import java.io.*;
import java.util.*;


class Main {
	public static int R, C, T;
	public static int[] air;
	public static int[][] board;
	public static int[] updr = {-1, 0, 1, 0};
	public static int[] updc = {0, 1, 0, -1};
	public static int[] downdr = {1, 0, -1, 0};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		T = Integer.parseInt(s[2]);
		board = new int[R][C];
		air = new int[2];
		Arrays.fill(air, -1);
		
		for(int i = 0; i < R; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < C; j++) {
				int v = Integer.parseInt(s[j]);
				board[i][j] = v;
				if(v == -1) {
					if(air[0] == -1) {
						air[0] = i;
					} else {
						air[1] = i;
					}
				}
			}
		}
		for(int i = 0; i < T; i++) {
			diff();
			rotate();
		}
		long answer = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(board[r][c] > 0) {
					answer += board[r][c];
				}
			}
		}
		System.out.print(answer);
	}
	public static void diff() {
		int[][] map = new int[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(board[r][c] >= 5) {
					int a = (int) Math.floor(board[r][c] / 5);
					int count = 0;
					for(int i = 0; i < 4; i++) {
						int dr = r + updr[i];
						int dc = c + updc[i];
						if(dr >= 0 && dr < R && dc >= 0 && dc < C && board[dr][dc] != -1) {
							map[dr][dc] += a;
							count++;
						}
					}
					map[r][c] += a * count * (-1);
				}
			}
		}
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				board[r][c] += map[r][c];
			}
		}
	}
	public static void rotate() {
		int nowr = air[0] - 1;
		int nowc = 0;
		board[air[0]][0] = 0;
		int dir = 0;
		while(dir < 4) {
			int nextr = nowr + updr[dir];
			int nextc = nowc + updc[dir];
			if(nextr >= 0 && nextr <= air[0]  && nextc >= 0 && nextc < C) {
				board[nowr][nowc] = board[nextr][nextc];
				nowr = nextr;
				nowc = nextc;
			} else {
				dir++;
			}
		}
		board[air[0]][0] = -1;
		board[air[1]][0] = 0;
		dir = 0;
		nowr = air[1] + 1;
		nowc = 0;
		while(dir < 4) {
			int nextr = nowr + downdr[dir];
			int nextc = nowc + updc[dir];
			if(nextr >= air[1] && nextr < R && nextc >= 0 && nextc < C) {
				board[nowr][nowc] = board[nextr][nextc];
				nowr = nextr;
				nowc = nextc;
			} else {
				dir++;
			}
		}
		board[air[1]][0] = -1;
	}
}