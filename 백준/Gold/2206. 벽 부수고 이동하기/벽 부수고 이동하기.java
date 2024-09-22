import java.io.*;
import java.util.*;

class Main {
	public static int N, M;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static char[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.print(bfs());
	}
	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1, 0});
		boolean[][][] visited = new boolean[N][M][2];
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			if(y == N-1 && x == M-1) {
				return now[2];
			}
			if(!visited[y][x][now[3]]) {
				visited[y][x][now[3]] = true;
				for(int[] d : directions) {
					int dy = y + d[0];
					int dx = x + d[1];
					if(dy >= 0 && dy < N && dx >= 0 && dx < M) {
						if(map[dy][dx] == '0' ) {
							q.offer(new int[] {dy, dx, now[2]+1, now[3]});
						} else {
							if(now[3] == 0) {
								q.offer(new int[] {dy, dx, now[2]+1, 1});
							}
						}
					}
				}
			}
			
		}
		return -1;
	}
}