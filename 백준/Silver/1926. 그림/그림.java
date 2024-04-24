import java.io.*;
import java.util.*;
public class Main {
	public static int M, N, count, size;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new char[N][M];
		visited = new boolean[N][M];
		count = 0;
		size = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine().replace(" ", "");
			map[i] = str.toCharArray();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					count++;
					visited[i][j] = true;
					size = Math.max(size, bfs(i, j));
				}
			}
		}
		System.out.println(count);
		System.out.print(size);
	}
	public static int bfs(int i , int j) {
		int temp = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			temp++;
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 && y < N && x >= 0 && x < M && map[y][x] == '1' && !visited[y][x]) {
					visited[y][x] = true;
					q.offer(new int[] {y, x});
				}
			}
		}
		return temp;
	}
}