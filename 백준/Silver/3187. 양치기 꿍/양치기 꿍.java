import java.io.*;
import java.util.*;
class Main {
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 인접한 네 방향
	public static int R, C, sheep, wolf;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		sheep = 0;
		wolf = 0;
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != '#' &&!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sheep).append(" ").append(wolf);
		System.out.print(sb);
	}
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		int s = 0;
		int w = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(map[now[0]][now[1]] == 'v') {
				w++;
			}
			else if(map[now[0]][now[1]] == 'k') {
				s++;
			}
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 && y < R && x >= 0 && x < C && map[y][x] != '#' && !visited[y][x]) {
					visited[y][x] = true;
					q.offer(new int[] {y, x});
				}
			}
		}
		if(s > w) {
			w = 0;
		} else {
			s = 0;
		}
		sheep += s;
		wolf += w;
	}
}