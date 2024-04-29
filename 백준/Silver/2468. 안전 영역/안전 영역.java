import java.io.*;
import java.util.*;
public class Main {
	public static int N, answer;
	public static int[][] map;
	public static Set<Integer> set;
	public static boolean[][] visited;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		set = new TreeSet<>();
		answer = 0;
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				set.add(map[i][j]-1);
			}
		}
		for(int min : set) {
			int temp = 0;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] > min) {
						temp++;
						visited[i][j] = true;
						bfs(i, j, min);
					}
				}
			}
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);
	}
	public static void bfs(int i, int j, int min) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 && y < N && x >=0 && x < N && !visited[y][x] && map[y][x] > min) {
					visited[y][x] = true;
					q.offer(new int[] {y, x});
				}
			}
		}
	}
}