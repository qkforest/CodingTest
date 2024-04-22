import java.io.*;
import java.util.*;
public class Main {
	public static int M, N, K;
	public static int[][] map;
	public static boolean[][] visited;
	public static List<Integer> list;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1},{0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		map = new int[M][N];
		visited = new boolean[M][N];
		list = new ArrayList<>();
		for(int i = 0; i < K; i++) {
			s = br.readLine().split(" ");
			for(int y = Integer.parseInt(s[1]); y < Integer.parseInt(s[3]); y++) {
				for(int x = Integer.parseInt(s[0]); x < Integer.parseInt(s[2]); x++) {
					map[M-1-y][x] = 1;
				}
			}
		}
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i)+ " ");
		}
		System.out.println(list.get(list.size() - 1));
	}
	public static void bfs(int i, int j) {
		int size = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 && y < M && x >= 0 && x < N && !visited[y][x] && map[y][x] == 0) {
					visited[y][x] = true;
					q.offer(new int[] {y, x});
					size++;
				}
			}
		}
		list.add(size);
	}
}