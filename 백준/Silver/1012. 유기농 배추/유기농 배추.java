import java.io.*;
import java.util.*;
public class Main {
	public static int M, N, K;
	public static int[][] map;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		for(int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);
			N = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);
			map = new int[N][M];
			for(int j = 0; j < K; j++) {
				s = br.readLine().split(" ");
				map[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
			}
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < M; x++) {
					if(map[y][x] == 1) {
						answer[i]++;
						bfs(y, x);
					}
				}
			}
		}
		for(int n : answer) {
			System.out.println(n);
		}
	}
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		map[i][j] = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 && y < N && x >= 0 && x < M && map[y][x] == 1) {
					map[y][x] = 0;
					q.offer(new int[] {y, x});
				}
			}
		}
	}
}