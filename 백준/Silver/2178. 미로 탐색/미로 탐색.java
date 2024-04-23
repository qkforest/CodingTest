import java.io.*;
import java.util.*;
public class Main {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		visited = new boolean[N][M];
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == N-1 && now[1] == M-1) {
				return now[2];
			}
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if((y >= 0 && y < N && x >= 0 && x < M) && map[y][x] == 1 && !visited[y][x]) {
					visited[y][x] = true;
					q.offer(new int[] {y, x ,now[2]+1});
				}
			}
		}
		return 0;
	}
}