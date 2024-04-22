import java.io.*;
import java.util.*;
public class Main {
	public static char[][] map;
	public static boolean[][] visited;
	public static int answer, N;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					answer++;
					visited[i][j] = true;
					bfs(i, j, map[i][j]);
				}
			}
		}
		System.out.print(answer + " ");
		visited = new boolean[N][N];
		answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					answer++;
					visited[i][j] = true;
					if(map[i][j] == 'B') {
						bfs(i, j, map[i][j]);
					} else {
						bfsCB(i, j, map[i][j]);
					}
				}
			}
		}
		System.out.println(answer);
	}
	public static void bfs(int i, int j, char c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if((y >=0 && y < N && x >=0 && x < N) && !visited[y][x] && map[y][x] == c) {
					visited[y][x] = true;
					q.offer(new int[] {y, x});
				}
			}
		}
	}
	public static void bfsCB(int i, int j, char c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if((y >=0 && y < N && x >=0 && x < N) && !visited[y][x] && map[y][x] != 'B') {
					visited[y][x] = true;
					q.offer(new int[] {y, x});
				}
			}
		}
	}
}