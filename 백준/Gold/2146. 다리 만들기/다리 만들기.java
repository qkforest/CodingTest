import java.io.*;
import java.util.*;
public class Main {
	public static int N, idx, answer;
	public static int[][] map;
	public static boolean[][] visited;
	public static Queue<int[]> bridge;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		idx = 0;
		answer = Integer.MAX_VALUE;
		bridge = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					idx++;
					map[i][j] = idx;
					visited[i][j] = true;
					bfs_island(i, j);
				}
			}
		}
		bfs_bridge();
		System.out.println(answer);
	}
	public static void bfs_island(int i , int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 && y < N && x >= 0 && x < N && !visited[y][x]) {
					visited[y][x] = true;
					if(map[y][x] == 1) {
						map[y][x] = idx;
						q.offer(new int[] {y, x});
					}
					else {
						bridge.offer(new int[] {y, x, idx});
					}
				}
			}
		}
	}
	public static void bfs_bridge() {
		while(!bridge.isEmpty()) {
			Queue<int[]> q = new LinkedList<>();
			visited = new boolean[N][N];
			int[] start = bridge.poll();
			int num = start[2];
			q.offer(new int[] {start[0], start[1], 1});
			visited[start[0]][start[1]] = true;
			while(!q.isEmpty()) {
				int[] now = q.poll();
				if(map[now[0]][now[1]] != 0){
					answer = Math.min(answer , now[2]-1);
					break;
				}
				for(int[] d : directions) {
					int y = now[0] + d[0];
					int x = now[1] + d[1];
					if(y >= 0 && y < N && x >= 0 && x < N && !visited[y][x] && map[y][x] != num) {
						visited[y][x] = true;
						if(now[2] == answer) {
							break;
						}
						q.offer(new int[] {y, x, now[2]+1});
					}
				}
			}
		}
	}
}