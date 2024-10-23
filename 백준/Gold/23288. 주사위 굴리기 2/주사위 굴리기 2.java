import java.util.*;
import java.io.*;

class Main {
	public static int N, M, answer;
	public static int[][] board;
	public static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		board = new int[N][M];
		answer = 0;
		for(int i = 0; i < N; i++) {
			 s = br.readLine().split(" ");
			 for(int j = 0; j < M; j++) {
				 board[i][j] = Integer.parseInt(s[j]);
			 }
		}
		int x = 0;
		int y = 0;
		int[] dice = {1, 5, 3, 2, 4, 6};
		int d = 0;
		for(int i = 0; i < K; i++) {
			int dy = y + directions[d][0];
			int dx = x + directions[d][1];
			if(dy < 0 || dy >= N || dx < 0 || dx >= M) {
				d = (d + 2) % 4;
				dy = y + directions[d][0];
				dx = x + directions[d][1];
			}
			int temp;
			switch(d) {
				case 0 : 
					temp = dice[2];
					dice[2] = dice[0];
					dice[0] = dice[4];
					dice[4] = dice[5];
					dice[5] = temp;
					break;
				case 1 :
					temp = dice[0];
					dice[0] = dice[3];
					dice[3] = dice[5];
					dice[5] = dice[1];
					dice[1] = temp;
					break;
				case 2 :
					temp = dice[0];
					dice[0] = dice[2];
					dice[2] = dice[5];
					dice[5] = dice[4];
					dice[4] = temp;
					break;
				case 3 :
					temp = dice[0];
					dice[0] = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[3];
					dice[3] = temp;
					
			}
			y = dy;
			x = dx;
			bfs(y, x);
			if(dice[5] > board[y][x]) {
				d = (d+1) % 4;
			}
			else if(dice[5] < board[y][x]) {
				d = (d+3) % 4;
			} 
		}
		System.out.print(answer);
	}
	public static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y , x});
		int num = board[y][x];
		boolean[][] visited = new boolean[N][M];
		while(!q.isEmpty()) {
			int[] now = q.poll();
			y = now[0];
			x = now[1];
			if(!visited[y][x]) {
				visited[y][x] = true;
				answer += board[y][x];
				for(int[] d : directions) {
					int dy = y + d[0];
					int dx = x + d[1];
					if(dy >= 0 && dy < N && dx >= 0 && dx < M && board[dy][dx] == num) {
						q.offer(new int[] {dy, dx});
					}
				}
			}
		}
	}
}